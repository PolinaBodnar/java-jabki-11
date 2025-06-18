package homework.exceptions;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("Товар с таким кодом не найден.");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}