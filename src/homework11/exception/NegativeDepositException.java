package homework11.exception;

public class NegativeDepositException extends Exception {
    public NegativeDepositException(String msg) {
        super(msg);
    }
}