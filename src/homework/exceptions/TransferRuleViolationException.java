package homework.exceptions;

public class TransferRuleViolationException extends Exception {
    public TransferRuleViolationException() {
        super("Нарушено правило перевода средств.");
    }

    public TransferRuleViolationException(String message) {
        super(message);
    }
}
