package homework.exceptions;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("Товар не найден.");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
