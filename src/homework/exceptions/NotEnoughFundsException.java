package homework.exceptions;

public class NotEnoughFundsException extends Exception {
    public NotEnoughFundsException() {
        super("Недостаточно средств для перевода.");
    }

    public NotEnoughFundsException(String message) {
        super(message);
    }
}
