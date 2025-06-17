package homework.exceptions;

public class UnknownProductCodeException extends Exception {
    public UnknownProductCodeException() {
        super("Товар с указанным кодом не найден.");
    }

    public UnknownProductCodeException(String message) {
        super(message);
    }
}
