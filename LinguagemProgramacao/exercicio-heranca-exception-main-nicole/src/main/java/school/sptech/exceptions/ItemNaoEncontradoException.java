package school.sptech.exceptions;

public class ItemNaoEncontradoException extends RuntimeException{

    public ItemNaoEncontradoException(String message) {
        super(message);
    }
}