import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private int id;
    private String nombreDep;
    private String descripcion;
    private List<Empleado> empleados;

    

    // Constructor
    public Departamento(int id, String nombreDep, String descripcion){
        this.id = id;
        this.nombreDep = nombreDep;
        this.descripcion = descripcion;
        this.empleados = new ArrayList<>();

    }
    //Gestion de Empleados
    public void agregarEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }
    /* Getters y Setters */
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombreDep(){
        return nombreDep;
    }
    public void setNombreDep(String nombreDep){
        this.nombreDep = nombreDep;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public List<Empleado> getEmpleados(){
        return empleados;
    }
    
}

