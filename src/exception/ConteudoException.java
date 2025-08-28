package exception;

/**
 * Exceção lançada para erros relacionados a Conteudo.
 */
public class ConteudoException extends RuntimeException {

    public ConteudoException(String mensagem) {
        super(mensagem);
    }
}
