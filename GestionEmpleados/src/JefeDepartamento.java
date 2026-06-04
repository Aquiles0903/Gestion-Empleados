import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es para los jefes de departamento.
 * Lideran un área, coordinan un equipo de gente y reciben un bono especial.
 * Hereda de {@link Empleado}.
 */
public class JefeDepartamento extends Empleado {

    /**
     * El departamento del que es jefe.
     */
    private Departamento depto;

    /**
     * La lista de personas del equipo que tiene a su cargo directo.
     */
    private List<Empleado> equipo;

    /**
     * El dinerito extra que gana por productividad.
     */
    private double bonoProductividad;

    /**
     * Constructor para crear un jefe. Recibe el bono inicial y crea una lista de equipo vacía.
     *
     * @param id                El ID del jefe.
     * @param nombre            Su nombre.
     * @param salario           El salario base.
     * @param bonoProductividad El bono inicial que le damos.
     */
    public JefeDepartamento(int id, String nombre, double salario, double bonoProductividad) {
        super(id, nombre, "Jefe de departamento", salario);
        this.bonoProductividad = bonoProductividad;
        this.equipo = new ArrayList<>();
    }

    /**
     * Para saber cuánto gana de bono de productividad.
     *
     * @return El bono de productividad.
     */
    public double getBonoProductividad() { 
        return bonoProductividad; 
    }

    /**
     * Para cambiarle el bono de productividad.
     *
     * @param bonoProductividad El nuevo bono de productividad.
     */
    public void setBonoProductividad(double bonoProductividad) {
         this.bonoProductividad = bonoProductividad; 
    }
    
    /**
     * Para saber qué departamento tiene asignado.
     *
     * @return El departamento a su cargo.
     */
    public Departamento getDepartamento() { 
        return depto; 
    }

    /**
     * Para ponerle el departamento que va a mandar.
     *
     * @param depto El departamento que le toca cuidar.
     */
    public void setDepartamento(Departamento depto) {
         this.depto = depto; 
    }

    /**
     * Añade un empleado a su lista de equipo. Si ya estaba en el equipo, da error.
     *
     * @param emp El empleado que sumamos al equipo.
     * @throws ElementoDuplicadoException Si el empleado ya estaba metido en este equipo.
     */
    public void agregarEmpleadoEquipo(Empleado emp) throws ElementoDuplicadoException {
        for (Empleado e : equipo) {
            if (e.getId() == emp.getId()) {
                throw new ElementoDuplicadoException("El empleado ya está en el equipo de este jefe.");
            }
        }
        equipo.add(emp);
    }

    /**
     * Quita a un empleado de su equipo usando su número de ID.
     *
     * @param empleadoId El ID del empleado a quitar.
     */
    public void removerEmpleadoEquipo(int empleadoId) {
        equipo.removeIf(e -> e.getId() == empleadoId);
    }

    /**
     * Quita a un empleado de la lista general de su departamento.
     *
     * @param empleadoId El ID del empleado a borrar del departamento.
     */
    public void removerEmpleadoDeDepartamento(int empleadoId) {
        if (depto != null) {
            depto.getEmpleados().removeIf(e -> e.getId() == empleadoId);
        }
    }

    /**
     * Imprime por consola los datos del jefe, como su bono y el departamento que lidera.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Bono de Productividad: $" + String.format("%.2f", bonoProductividad));
        System.out.println("Salario Total: $" + String.format("%.2f", calcularSalario()));
        if (depto != null) {
            System.out.println("Departamento a cargo: " + depto.getNombreDep());
        }
    }
}