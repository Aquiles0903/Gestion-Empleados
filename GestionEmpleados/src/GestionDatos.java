import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase sirve para guardar todos los datos en memoria (empleados, proyectos y deptos).
 * También genera las IDs nuevas de forma automática para que no se repitan.
 * Se puede guardar porque es Serializable.
 */
public class GestionDatos implements Serializable {
    /**
     * El serial de la versión para que Java no se queje al guardarlo.
     */
    private static final long serialVersionUID = 1L;

    /**
     * La lista de todos los empleados que tenemos registrados.
     */
    private List<Empleado> empleados;

    /**
     * La lista de todos los proyectos que tenemos registrados.
     */
    private List<Proyecto> proyectos;

    /**
     * La lista de todos los departamentos que tenemos registrados.
     */
    private List<Departamento> departamentos;

    /**
     * Para llevar la cuenta del último ID de empleado usado y no repetir.
     */
    private int maxIdEmpleado;

    /**
     * Para llevar la cuenta del último ID de proyecto usado y no repetir.
     */
    private int maxIdProyecto;

    /**
     * Para llevar la cuenta del último ID de departamento usado y no repetir.
     */
    private int maxIdDepartamento;

    /**
     * Constructor para iniciar la base de datos en memoria.
     * Crea las listas vacías y pone los contadores de IDs en 0.
     */
    public GestionDatos() {
        empleados = new ArrayList<>();
        proyectos = new ArrayList<>();
        departamentos = new ArrayList<>();

        maxIdEmpleado = 0;
        maxIdProyecto = 0;
        maxIdDepartamento = 0;
    }

    /**
     * Crea un ID nuevo de empleado sumándole uno al anterior.
     *
     * @return El nuevo ID de empleado.
     */
    public int generarIdEmpleado() {
        return ++maxIdEmpleado;
    }

    /**
     * Crea un ID nuevo de proyecto sumándole uno al anterior.
     *
     * @return El nuevo ID de proyecto.
     */
    public int generarIdProyecto() {
        return ++maxIdProyecto;
    }

    /**
     * Crea un ID nuevo de departamento sumándole uno al anterior.
     *
     * @return El nuevo ID de departamento.
     */
    public int generarIdDepartamento() {
        return ++maxIdDepartamento;
    }

    /**
     * Guarda un empleado en la lista de empleados de la empresa.
     *
     * @param emp El empleado a agregar.
     * @throws ElementoDuplicadoException Si el empleado ya está registrado.
     */
    public void agregarEmpleado(Empleado emp) throws ElementoDuplicadoException {
        if (emp == null) {
            return;
        }
        for (Empleado e : empleados) {
            if (e.getId() == emp.getId()) {
                throw new ElementoDuplicadoException("El empleado ya existe en el sistema.");
            }
        }
        empleados.add(emp);
    }
    
    /**
     * Busca a un empleado por su número de ID. Si no lo encuentra, tira un error.
     *
     * @param id El ID del empleado que buscamos.
     * @return El objeto Empleado que encontramos.
     * @throws ElementoNoEncontradoException Si no existe ningún empleado con ese ID.
     */
    public Empleado buscarEmpleado(int id) throws ElementoNoEncontradoException {
        for (Empleado e : empleados) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new ElementoNoEncontradoException("No se encontró ningún empleado con ID " + id);
    }

    /**
     * Busca a un empleado por su nombre completo sin importar las mayúsculas.
     * Si no lo encuentra, tira un error.
     *
     * @param nombre El nombre a buscar.
     * @return El objeto Empleado que encontramos.
     * @throws ElementoNoEncontradoException Si no encontramos a nadie con ese nombre.
     */
    public Empleado buscarEmpleadoPorNombre(String nombre) throws ElementoNoEncontradoException {
        for (Empleado e : empleados) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        throw new ElementoNoEncontradoException("No se encontró ningún empleado con nombre " + nombre);
    }

    /**
     * Devuelve una copia de la lista de todos los empleados de la oficina.
     *
     * @return La lista copiada de empleados.
     */
    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    /**
     * Borra a un empleado por su ID y le quita las referencias en los proyectos y
     * departamentos en los que estaba para que no quede huerfano.
     * Si el ID no existe, tira un error.
     *
     * @param id El ID del empleado que vamos a borrar.
     * @throws ElementoNoEncontradoException Si no existe ningún empleado con ese ID.
     */
    public void eliminarEmpleado(int id) throws ElementoNoEncontradoException {
        boolean removido = empleados.removeIf(e -> e.getId() == id);
        if (!removido) {
            throw new ElementoNoEncontradoException("No se encontró ningún empleado con ID " + id);
        }
        // Limpiar referencias en departamentos y proyectos
        for (Departamento d : departamentos) {
            if (d.getJefe() != null) {
                d.getJefe().removerEmpleadoDeDepartamento(id);
                d.getJefe().removerEmpleadoEquipo(id);
            } else {
                d.getEmpleados().removeIf(e -> e.getId() == id);
            }
        }
        for (Proyecto p : proyectos) {
            p.removerEmpleado(id);
        }
    }

    /**
     * Guarda un proyecto en la lista general del sistema.
     *
     * @param proy El proyecto a meter.
     * @throws ElementoDuplicadoException Si el proyecto ya está registrado.
     */
    public void agregarProyecto(Proyecto proy) throws ElementoDuplicadoException {
        if (proy == null) {
            return;
        }
        for (Proyecto p : proyectos) {
            if (p.getId() == proy.getId()) {
                throw new ElementoDuplicadoException("El proyecto ya existe en el sistema.");
            }
        }
        proyectos.add(proy);
    }

    /**
     * Devuelve una copia de la lista de todos los proyectos.
     *
     * @return Copia de la lista de proyectos.
     */
    public List<Proyecto> getProyectos() {
        return new ArrayList<>(proyectos);
    }
    
    /**
     * Busca un proyecto en la lista usando su ID. Si no lo encuentra, tira un error.
     *
     * @param id El ID del proyecto.
     * @return El proyecto encontrado.
     * @throws ElementoNoEncontradoException Si el proyecto no existe.
     */
    public Proyecto buscarProyecto(int id) throws ElementoNoEncontradoException {
        for (Proyecto p : proyectos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new ElementoNoEncontradoException("No se encontró proyecto con ID " + id);
    }

    /**
     * Guarda un departamento en la lista general de la empresa.
     *
     * @param dep El departamento a meter.
     * @throws ElementoDuplicadoException Si el departamento ya está registrado.
     */
    public void agregarDepartamento(Departamento dep) throws ElementoDuplicadoException {
        if (dep == null) {
            return;
        }
        for (Departamento d : departamentos) {
            if (d.getId() == dep.getId()) {
                throw new ElementoDuplicadoException("El departamento ya existe en el sistema.");
            }
        }
        departamentos.add(dep);
    }

    /**
     * Devuelve una copia de la lista de departamentos.
     *
     * @return Copia de la lista de departamentos.
     */
    public List<Departamento> getDepartamentos() {
        return new ArrayList<>(departamentos);
    }
    
    /**
     * Busca un departamento por su ID. Si no lo encuentra, tira error.
     *
     * @param id El ID del departamento.
     * @return El departamento encontrado.
     * @throws ElementoNoEncontradoException Si no existe el depto con ese ID.
     */
    public Departamento buscarDepartamento(int id) throws ElementoNoEncontradoException {
        for (Departamento d : departamentos) {
            if (d.getId() == id) {
                return d;
            }
        }
        throw new ElementoNoEncontradoException("No se encontró departamento con ID " + id);
    }
}
