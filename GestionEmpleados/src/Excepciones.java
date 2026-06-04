/**
 * Esta excepción salta cuando nos pasamos del presupuesto que tenemos disponible.
 */
class PresupuestoExcedidoException extends Exception {
    /**
     * Constructor para crear el error con un mensaje personalizado.
     *
     * @param message El mensaje explicativo de qué pasó.
     */
    public PresupuestoExcedidoException(String message) {
        super(message);
    }
}

/**
 * Excepción para avisar que estamos metiendo algo que ya existe (repetido).
 */
class ElementoDuplicadoException extends Exception {
    /**
     * Constructor que recibe el texto de error.
     *
     * @param message Mensaje detallando el error del elemento repetido.
     */
    public ElementoDuplicadoException(String message) {
        super(message);
    }
}

/**
 * Excepción que usamos cuando buscamos un empleado, proyecto o departamento y no existe.
 */
class ElementoNoEncontradoException extends Exception {
    /**
     * Constructor que nos deja poner un mensaje cuando no encontramos algo.
     *
     * @param message Texto del error.
     */
    public ElementoNoEncontradoException(String message) {
        super(message);
    }
}
