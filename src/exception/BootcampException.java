package exception;

/**
 * Exceção lancada para erros relacionados a Bootcamp.
 */
public class BootcampException extends RuntimeException {

    public BootcampException(String mensagem) {
        super(mensagem);
    }
}
