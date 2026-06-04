import java.util.ArrayList;
import java.util.List;

/**
 * Clase para representar a un gerente. Los gerentes manejan departamentos, presupuestos y proyectos.
 * Hereda de {@link Empleado}.
 */
public class Gerente extends Empleado {

    /**
     * El bono anual extra que se lleva el gerente.
     */
    private double bonoAnual;

    /**
     * Lista de departamentos que este gerente tiene a su cargo.
     */
    private List<Departamento> deptoSupervisados;

    /**
     * La cantidad de dinero total que le dan al gerente para repartir.
     */
    private double presupAsignado;

    /**
     * El dinero que ya se gastó o se asignó del presupuesto total.
     */
    private double presupUtilizado;

    /**
     * Proyectos en los que este gerente está metido controlando cosas.
     */
    private List<Proyecto> proyectos;

    /**
     * Constructor para crear un Gerente. El bonoAnual se pone en 0 por defecto.
     *
     * @param id             El ID único para este gerente.
     * @param nombre         El nombre del gerente.
     * @param puesto         El puesto (se va a poner "Gerente" de todas formas).
     * @param salario        Su salario base mensual.
     * @param bonoAnual      El bono inicial (pero el constructor lo pone en 0.0).
     * @param presupAsignado El presupuesto total que le dejamos manejar.
     */
    public Gerente(int id, String nombre, String puesto, double salario, double bonoAnual, double presupAsignado) {
        super(id, nombre, "Gerente", salario);
        this.bonoAnual = 0.0;
        this.presupAsignado = presupAsignado;
        this.deptoSupervisados = new ArrayList<>();
        this.proyectos = new ArrayList<>();
    }
    
    /**
     * Guarda un departamento en la lista de los que vigila este gerente.
     *
     * @param depto El departamento nuevo a vigilar.
     */
    public void agregarDepto(Departamento depto) {
        this.deptoSupervisados.add(depto);
    }

    /**
     * Para saber el bono anual que tiene el gerente.
     *
     * @return El bono anual.
     */
    public double getBonoAnual() {
        return bonoAnual;
    }

    /**
     * Para cambiarle el bono anual al gerente.
     *
     * @param bonoAnual El nuevo bono.
     */
    public void setBonoAnual(double bonoAnual) {
        this.bonoAnual = bonoAnual;
    }

    /**
     * Para saber cuánto presupuesto total le dieron.
     *
     * @return El presupuesto asignado.
     */
    public double getPresupAsignado() {
        return presupAsignado;
    }

    /**
     * Para cambiar el presupuesto total asignado.
     *
     * @param presupAsignado El nuevo valor del presupuesto asignado.
     */
    public void setPresupAsig(double presupAsignado) {
        this.presupAsignado = presupAsignado;
    }

    /**
     * Para ver cuánto dinero ya asignamos o gastamos de su presupuesto.
     *
     * @return El presupuesto utilizado hasta ahora.
     */
    public double getPresupUtilizado() {
        return presupUtilizado;
    }

    /**
     * Para actualizar el presupuesto que ya se gastó.
     *
     * @param presupUtilizado El nuevo monto utilizado.
     */
    public void setPresupUtilizado(double presupUtilizado) {
        this.presupUtilizado = presupUtilizado;
    }

    /**
     * Calcula cuánto va a cobrar al final sumando el bono al salario base.
     *
     * @return El salario base más el bono.
     */
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonoAnual;
    }
    
    /**
     * Le da dinero a un departamento sacándolo de su presupuesto asignado.
     * Si no le alcanza el dinero, tira un error.
     *
     * @param depto       A qué departamento le damos dinero.
     * @param presupDepto Cuánto dinero le vamos a dar.
     * @throws PresupuestoExcedidoException Si nos pasamos de lo que tiene el gerente asignado.
     */
    public void asignarPresupADepto(Departamento depto, double presupDepto) throws PresupuestoExcedidoException {
        if (presupUtilizado + presupDepto > presupAsignado) {
            throw new PresupuestoExcedidoException("No hay suficiente presupuesto disponible.");
        }
        presupUtilizado += presupDepto;
        depto.setPresupuesto(depto.getPresupuesto() + presupDepto);
    }

    /**
     * Muestra todos los datos del gerente, incluyendo sus bonos y presupuestos, en la pantalla.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Bono Anual: $" + String.format("%.2f", bonoAnual));
        System.out.println("Presupuesto Asignado: $" + String.format("%.2f", presupAsignado));
        System.out.println("Presupuesto Utilizado: $" + String.format("%.2f", presupUtilizado));
        System.out.println("Salario Total: $" + String.format("%.2f", calcularSalario()));
    }

    /**
     * Le asigna un proyecto nuevo al gerente. Si ya lo tiene asignado de antes, tira un error de duplicado.
     *
     * @param proy El proyecto a agregar.
     * @throws ElementoDuplicadoException Si el proyecto ya estaba en su lista.
     */
    public void agregarProyecto(Proyecto proy) throws ElementoDuplicadoException {
        for (Proyecto p : proyectos) {
            if (p.getId() == proy.getId()) {
                throw new ElementoDuplicadoException("El proyecto ya está asignado a este gerente.");
            }
        }
        proyectos.add(proy);
    }

    /**
     * Le da dinero a un proyecto sacándolo de su presupuesto. Si se pasa de lo que tiene, tira error.
     *
     * @param proy     El proyecto que necesita presupuesto.
     * @param cantidad El dinero a pasarle.
     * @throws PresupuestoExcedidoException Si nos pasamos del presupuesto total disponible del gerente.
     */
    public void asignarPresupuestoProyecto(Proyecto proy, double cantidad) throws PresupuestoExcedidoException {
        if (presupUtilizado + cantidad > presupAsignado) {
            throw new PresupuestoExcedidoException("No hay suficiente presupuesto disponible.");
        }
        presupUtilizado += cantidad;
        proy.setPresupuesto(proy.getPresupuesto() + cantidad);
    }
}