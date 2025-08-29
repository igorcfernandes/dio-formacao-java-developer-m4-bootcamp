package exception;

/**
 * Exceção lançada para erros relacionados a Dev.
 */
public class DevException extends RuntimeException {

    public DevException(String mensagem) {
        super(mensagem);
    }
}
