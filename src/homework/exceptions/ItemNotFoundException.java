package homework.exceptions;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("Товар с данным кодом не найден.");
    }
}
