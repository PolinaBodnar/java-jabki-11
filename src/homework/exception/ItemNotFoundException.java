package homework.exception;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String code) {
        super("Товар с кодом '" + code + "' не найден.");
    }
}