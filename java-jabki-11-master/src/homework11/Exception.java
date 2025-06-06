package homework11;

import java.io.*;
import java.util.*;

// Исключения из заданий
class NegativeDepositException extends Exception {
    public NegativeDepositException(String message) {
        super(message);
    }
}

class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}

class LoginFailedException extends Exception {
    public LoginFailedException(String message) {
        super(message);
    }
}

class InvalidTransferAmountException extends Exception {
    public InvalidTransferAmountException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidRatingException extends Exception {
    public InvalidRatingException(String message) {
        super(message);
    }
}