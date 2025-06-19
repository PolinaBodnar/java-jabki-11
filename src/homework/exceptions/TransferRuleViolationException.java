package homework.exceptions;

public class TransferRuleViolationException extends Exception {
    public TransferRuleViolationException() {
        super("Сумма перевода должна быть положительной.");
    }

    public TransferRuleViolationException(String message) {
        super(message);
    }
}
