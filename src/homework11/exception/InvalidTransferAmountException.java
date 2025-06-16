package homework11.exception;

public class InvalidTransferAmountException extends Exception {
    public InvalidTransferAmountException(String msg) {
        super(msg);
    }
}