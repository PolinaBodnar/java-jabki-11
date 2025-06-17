package homework.exceptions;

public class BadDepositException extends Exception {
    public BadDepositException() {
        super("Сумма депозита должна быть больше нуля.");
    }

    public BadDepositException(String message) {
        super(message);
    }
}
