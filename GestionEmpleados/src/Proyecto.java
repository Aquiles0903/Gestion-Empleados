import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Proyecto {

    private int id;
    private String nombreProyecto;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private List<Empleado> empladosAsoc;

    // Constructor
    public Proyecto(int id, String nombreProyecto, String descripcion, LocalDate fechaInicio, LocalDate fechaFinal){
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.empladosAsoc = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleadoAsoc){
        this.empladosAsoc.add(empleadoAsoc);
    }
    /* Getters y Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    
}