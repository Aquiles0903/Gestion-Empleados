import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
public class Nomina {
    private List<Empleado> empleados;
    private LocalDate periodoPago;
    private double nominaTotal;

public Nomina(LocalDate periodoPago, double nominaTotal){
    this.empleados = new ArrayList<>();
    this.periodoPago = periodoPago;
    this.nominaTotal = 0.0;
}
// Manejo de Empleados
public void agregarEmpleado(Empleado empleado){
    this.empleados.add(empleado);
}
/* Getters y Setters */

public List<Empleado> getEmpleados() {
    return empleados;
}
public void setEmpleados(List<Empleado> empleados) {
    this.empleados = empleados;
}
public LocalDate getPeriodoPago() {
    return periodoPago;
}
public void setPeriodoPago(LocalDate periodoPago) {
    this.periodoPago = periodoPago;
}
public double getNominaTotal() {
    return nominaTotal;
}
public void setNominaTotal(double nominaTotal) {
    this.nominaTotal = nominaTotal;
}






    
}