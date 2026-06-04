import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es para guardar la info de los programadores.
 * Saben un lenguaje principal, hacen horas extra y tienen proyectos asignados.
 * Hereda de {@link Empleado}.
 */
public class Desarrollador extends Empleado {

    /**
     * El lenguaje de programación que más usa el programador (como Java o C++).
     */
    private String lenguajePrincipal;

    /**
     * Las horas extra que ha acumulado metiendo código.
     */
    private int horasExtra;

    /**
     * La lista de proyectos en los que está metido trabajando.
     */
    private List<Proyecto> proyectos;

    /**
     * Constructor para crear un programador nuevo. Las horas extra empiezan en 0.
     *
     * @param id                El ID del programador.
     * @param nombre            Su nombre.
     * @param salario           Su salario base.
     * @param lenguajePrincipal El lenguaje que domina.
     */
    public Desarrollador(int id, String nombre, double salario, String lenguajePrincipal) {
        super(id, nombre, "Desarrollador", salario);
        this.lenguajePrincipal = lenguajePrincipal;
        this.horasExtra = 0;
        this.proyectos = new ArrayList<>();
    }

    /**
     * Para saber qué lenguaje principal usa.
     *
     * @return El nombre del lenguaje.
     */
    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    /**
     * Para cambiarle el lenguaje principal.
     *
     * @param lenguajePrincipal El nuevo lenguaje principal.
     */
    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    /**
     * Para ver cuántas horas extra lleva acumuladas.
     *
     * @return Las horas extra.
     */
    public int getHorasExtra() {
        return horasExtra;
    }

    /**
     * Suma horas extra a las que ya tenía guardadas de antes.
     *
     * @param horas Las horas que le vamos a sumar.
     */
    public void setHorasExtra(int horas) {
        this.horasExtra += horas;
    }
   
    /**
     * Le mete un proyecto nuevo a su lista. Si ya estaba asignado a ese proyecto de antes, da un error.
     *
     * @param proy El proyecto a asignarle.
     * @throws ElementoDuplicadoException Si el programador ya tenía ese proyecto.
     */
    public void asignarProyecto(Proyecto proy) throws ElementoDuplicadoException {
        for (Proyecto p : proyectos) {
            if (p.getId() == proy.getId()) {
                throw new ElementoDuplicadoException("El desarrollador ya está asignado a este proyecto.");
            }
        }
        proyectos.add(proy);
    }

    /**
     * Quita un proyecto de su lista usando el número de ID.
     *
     * @param proyectoId El ID del proyecto que queremos quitar.
     */
    public void removerProyecto(int proyectoId) {
        proyectos.removeIf(p -> p.getId() == proyectoId);
    }

    /**
     * Calcula cuánto va a ganar en total sumando las horas extra.
     * Cada hora extra se paga a un precio fijo de $15.0.
     *
     * @return El salario final.
     */
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (horasExtra * 15.0);
    }
}