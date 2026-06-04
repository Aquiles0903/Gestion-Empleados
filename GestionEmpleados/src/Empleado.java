import java.io.Serializable;

/**
 * Esta es la clase padre para guardar los datos básicos de cualquier empleado de la oficina.
 * Se puede guardar en archivos porque implementa Serializable.
 */
public class Empleado implements Serializable {
    /**
     * El serial de la versión para que Java no se queje al guardarlo.
     */
    private static final long serialVersionUID = 1L;

    /**
     * El número ID del empleado para identificarlo rápido.
     */
    private int id;

    /**
     * El nombre completo del empleado.
     */
    private String nombre;

    /**
     * El puesto de trabajo que tiene en la empresa.
     */
    private String puesto;

    /**
     * El salario base de este empleado antes de bonos o extras.
     */
    private double salario;

    /**
     * Constructor para crear un empleado nuevo con todos sus datos desde el inicio.
     *
     * @param id      El número de ID que le toca.
     * @param nombre  Su nombre y apellido.
     * @param puesto  Qué trabajo hace.
     * @param salario El dinero que gana de base.
     */
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    /**
     * Para conseguir el ID del empleado.
     *
     * @return El ID numérico.
     */
    public int getId() {
        return id;
    }

    /**
     * Para cambiarle el ID al empleado.
     *
     * @param id El nuevo ID que queremos ponerle.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Para conseguir el nombre del empleado.
     *
     * @return El nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Para cambiar el nombre del empleado.
     *
     * @param nombre El nombre nuevo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Para saber qué puesto tiene este empleado.
     *
     * @return El nombre del puesto.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Para cambiarle el puesto a este empleado.
     *
     * @param puesto El nuevo puesto.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Para saber cuánto es su salario base.
     *
     * @return El salario base actual.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Para cambiarle el salario base a este empleado.
     *
     * @param salario El nuevo salario base.
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * Calcula cuánto va a ganar el empleado. En esta clase padre
     * solo devuelve el salario base directamente.
     *
     * @return El salario total calculado.
     */
    public double calcularSalario() {
        return salario;
    }

    /**
     * Imprime en pantalla todos los datos del empleado para verlos fácil por consola.
     */
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Puesto: " + puesto);
        System.out.println("Salario : $" + String.format("%.2f", calcularSalario()));
    }
}





