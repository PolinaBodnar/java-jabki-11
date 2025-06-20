package homework.exception;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("Товар с данным кодом не найден.");
    }
}
