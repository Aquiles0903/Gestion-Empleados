import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Clase para representar un proyecto temporal de la oficina.
 * Tiene sus fechas, su presupuesto y la gente que trabaja en él.
 * Implementa Serializable para poder guardarse.
 */
public class Proyecto implements Serializable {
    /**
     * El serial de la versión para que Java no se queje al guardarlo.
     */
    private static final long serialVersionUID = 1L;

    /**
     * El ID único del proyecto.
     */
    private int id;

    /**
     * El nombre del proyecto.
     */
    private String nombreProyecto;

    /**
     * La descripción de qué se hace en el proyecto.
     */
    private String descripcion;

    /**
     * Fecha en la que arranca el proyecto.
     */
    private LocalDate fechaInicio;

    /**
     * Fecha en la que tiene que estar terminado sí o sí.
     */
    private LocalDate fechaFinal;

    /**
     * La lista de empleados que están metidos trabajando en este proyecto.
     */
    private List<Empleado> empleadosAsoc;

    /**
     * La plata asignada para gastar en el proyecto.
     */
    private double presupuesto;

    /**
     * Constructor para crear un proyecto. El presupuesto empieza en 0.0.
     *
     * @param id             Su ID de proyecto.
     * @param nombreProyecto El nombre que le ponemos.
     * @param descripcion    Para qué sirve.
     * @param fechaInicio    Cuándo empieza.
     * @param fechaFinal     Cuándo se termina.
     */
    public Proyecto(int id, String nombreProyecto, String descripcion, LocalDate fechaInicio, LocalDate fechaFinal) throws FechaInvalidaException {
        if (fechaInicio == null) {
            throw new FechaInvalidaException("La fecha de inicio no puede ser nula.");
        }
        if (fechaFinal == null) {
            throw new FechaInvalidaException("La fecha de finalización no puede ser nula.");
        }
        if (fechaFinal.isBefore(fechaInicio)) {
            throw new FechaInvalidaException("La fecha de finalización no puede ser anterior a la fecha de inicio.");
        }
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.empleadosAsoc = new ArrayList<>();
        this.presupuesto = 0.0;
    }

    /**
     * Añade un empleado al proyecto si no es null y si no estaba ya metido.
     *
     * @param emp El empleado que vamos a sumar.
     * @throws ElementoDuplicadoException Si el empleado ya estaba asignado a este proyecto.
     */
    public void agregarEmpleado(Empleado emp) throws ElementoDuplicadoException {
        if (emp == null) {
            return;
        }
        for (Empleado e : empleadosAsoc) {
            if (e.getId() == emp.getId()) {
                throw new ElementoDuplicadoException("El empleado ya está asignado a este proyecto.");
            }
        }
        empleadosAsoc.add(emp);
    }

    /**
     * Quita a un empleado del proyecto usando su número de ID.
     *
     * @param empleadoId El ID del empleado a quitar.
     */
    public void removerEmpleado(int empleadoId) {
        empleadosAsoc.removeIf(e -> e.getId() == empleadoId);
    }
    
    /**
     * Para conseguir el ID del proyecto.
     *
     * @return El ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Para cambiarle el ID al proyecto.
     *
     * @param id El nuevo ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Para conseguir el nombre del proyecto.
     *
     * @return El nombre.
     */
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    /**
     * Para cambiar el nombre del proyecto.
     *
     * @param nombreProyecto El nuevo nombre.
     */
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    /**
     * Para saber de qué trata el proyecto.
     *
     * @return La descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Para cambiar la descripción.
     *
     * @param descripcion La nueva descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Para saber cuándo empieza el proyecto.
     *
     * @return La fecha de inicio.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Para cambiar la fecha de inicio.
     *
     * @param fechaInicio La fecha nueva de inicio.
     */
    public void setFechaInicio(LocalDate fechaInicio) throws FechaInvalidaException {
        if (fechaInicio == null) {
            throw new FechaInvalidaException("La fecha de inicio no puede ser nula.");
        }
        if (this.fechaFinal != null && this.fechaFinal.isBefore(fechaInicio)) {
            throw new FechaInvalidaException("La fecha de inicio no puede ser posterior a la fecha de finalización.");
        }
        this.fechaInicio = fechaInicio;
    }

    /**
     * Para saber la fecha en la que se termina.
     *
     * @return La fecha final.
     */
    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Para cambiar la fecha de finalización.
     *
     * @param fechaFinal La nueva fecha final.
     */
    public void setFechaFinal(LocalDate fechaFinal) throws FechaInvalidaException {
        if (fechaFinal == null) {
            throw new FechaInvalidaException("La fecha de finalización no puede ser nula.");
        }
        if (this.fechaInicio != null && fechaFinal.isBefore(this.fechaInicio)) {
            throw new FechaInvalidaException("La fecha de finalización no puede ser anterior a la fecha de inicio.");
        }
        this.fechaFinal = fechaFinal;
    }

    /**
     * Para saber el presupuesto del proyecto.
     *
     * @return El presupuesto.
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * Para cambiar el presupuesto del proyecto.
     *
     * @param presupuesto La nueva cantidad de plata.
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * Para conseguir la lista de empleados asignados.
     *
     * @return Una copia de la lista de su gente.
     */
    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleadosAsoc);
    }
}