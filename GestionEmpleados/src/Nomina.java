import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Clase para armar la nómina de los empleados de un mes o periodo.
 * Nos deja sumar los sueldos y armar un reporte.
 */
public class Nomina {

    /**
     * La lista de empleados que entran en esta nómina.
     */
    private List<Empleado> empleados;

    /**
     * La fecha de pago de esta nómina.
     */
    private LocalDate periodoPago;

    /**
     * Constructor para crear la nómina. Le pasamos los empleados y la fecha de pago.
     *
     * @param empleados Lista inicial de empleados para la nómina.
     * @param periodo   La fecha del periodo de pago.
     */
    public Nomina(List<Empleado> empleados, LocalDate periodo) {
        this.empleados = new ArrayList<>(empleados);
        this.periodoPago = periodo;
    }

    /**
     * Mete un empleado a la nómina si no es null.
     *
     * @param emp El empleado nuevo para la lista.
     */
    public void agregarEmpleado(Empleado emp) {
        if (emp != null) {
            this.empleados.add(emp);
        }
    }

    /**
     * Para ver quiénes están en la nómina.
     *
     * @return La lista de empleados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Para cambiar de golpe a todos los empleados de la nómina por otra lista.
     *
     * @param empleados La nueva lista de empleados.
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Para saber qué fecha de pago tiene esta nómina.
     *
     * @return La fecha de pago.
     */
    public LocalDate getPeriodoPago() {
        return periodoPago;
    }

    /**
     * Para cambiar la fecha de pago.
     *
     * @param periodoPago La nueva fecha de pago.
     */
    public void setPeriodoPago(LocalDate periodoPago) {
        this.periodoPago = periodoPago;
    }

    /**
     * Suma los salarios base de todos.
     * Ojo: usa el sueldo base y no tiene en cuenta bonos ni horas extra.
     *
     * @return El total de los sueldos base.
     */
    public double getNominaTotal() {
        double nominaTotal = 0.0;
        for (Empleado emp : this.empleados) {
            nominaTotal += emp.getSalario(); 
        }
        return nominaTotal;
    }

    /**
     * Muestra el detalle de la nómina en pantalla por consola,
     * sumando los salarios calculados (con bonos u horas extra) de cada uno.
     */
    public void mostrarNomina() {
        System.out.println("\n--- Nómina: " + periodoPago + " ---");
        for (Empleado e : empleados) {
            System.out.println("- " + e.getNombre() + " (" + e.getPuesto() + "): $" 
                + String.format("%.2f", e.calcularSalario()));
        }
        System.out.println("---------------------------------");
        System.out.println("Nómina Total: $" + String.format("%.2f", getNominaTotal()));
    }
}