package homework.exceptions;

public class TransferRuleViolationException extends Exception {
    public TransferRuleViolationException() {
        super("Нарушение правил перевода.");
    }

    public TransferRuleViolationException(String message) {
        super(message);
    }
}
