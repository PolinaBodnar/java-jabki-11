package homework.exceptions;

public class TransferRuleViolationException extends Exception {
    public TransferRuleViolationException() {
        super("Нарушены правила перевода.");
    }

    public TransferRuleViolationException(String message) {
        super(message);
    }
}
