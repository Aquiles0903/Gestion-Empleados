import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para armar un departamento (como Sistemas o Contabilidad).
 * Tiene un presupuesto asignado, su gente y un jefe.
 * Implementa Serializable para poder guardarse en archivos.
 */
public class Departamento implements Serializable {
    /**
     * El serial de la versión para que Java no se queje al guardarlo.
     */
    private static final long serialVersionUID = 1L;

    /**
     * El ID numérico del departamento.
     */
    private int id;

    /**
     * El nombre del departamento (ej. "Ventas").
     */
    private String nombreDep;

    /**
     * De qué se trata este departamento (una pequeña explicación).
     */
    private String descripcion;

    /**
     * La gente que trabaja en este departamento.
     */
    private List<Empleado> empleados;

    /**
     * La plata que tiene asignada el departamento.
     */
    private double presupuesto;

    /**
     * El jefe encargado de dirigir todo aquí.
     */
    private JefeDepartamento jefe;

    /**
     * Constructor para crear un departamento. El presupuesto empieza en 0 por defecto.
     *
     * @param id          El número de ID que le toca.
     * @param nombreDep   El nombre del depto.
     * @param descripcion La descripción de qué hacen.
     * @param pres        Presupuesto inicial (se pone en 0.0 igual).
     */
    public Departamento(int id, String nombreDep, String descripcion, double pres) {
        this.id = id;
        this.nombreDep = nombreDep;
        this.descripcion = descripcion;
        this.empleados = new ArrayList<>();
        this.presupuesto = 0.0;
    }

    /**
     * Mete un empleado a la lista del departamento si no es null y si no lo habíamos metido ya.
     *
     * @param emp El empleado a meter.
     * @throws ElementoDuplicadoException Si el empleado ya está en el departamento.
     */
    public void agregarEmpleado(Empleado emp) throws ElementoDuplicadoException {
        if (emp == null) {
            return;
        }
        for (Empleado e : empleados) {
            if (e.getId() == emp.getId()) {
                throw new ElementoDuplicadoException("El empleado ya está en el departamento.");
            }
        }
        empleados.add(emp);
    }

    /**
     * Para conseguir el ID del departamento.
     *
     * @return El ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Para cambiarle el ID al depto.
     *
     * @param id El nuevo ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Para saber el nombre del depto.
     *
     * @return El nombre.
     */
    public String getNombreDep() {
        return nombreDep;
    }

    /**
     * Para cambiar el nombre del depto.
     *
     * @param nombreDep El nombre nuevo.
     */
    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }

    /**
     * Para saber la descripción de qué hace el depto.
     *
     * @return La descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Para cambiar la descripción.
     *
     * @param descripcion La descripción nueva.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Para obtener la lista de su gente.
     *
     * @return La lista de empleados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Para saber el presupuesto de este depto.
     *
     * @return El presupuesto.
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * Para cambiar el presupuesto del depto.
     *
     * @param presupuesto La nueva cantidad de plata.
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * Para saber quién es el jefe del departamento.
     *
     * @return El jefe de departamento.
     */
    public JefeDepartamento getJefe() {
        return jefe;
    }

    /**
     * Para ponerle un jefe a cargo al departamento.
     *
     * @param jefe El jefe que va a mandar aquí.
     */
    public void setJefe(JefeDepartamento jefe) {
        this.jefe = jefe;
    }
}

