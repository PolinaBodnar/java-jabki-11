package homework.exceptions;

public class InvalidRatingException extends Exception {
    public InvalidRatingException() {
        super("Недопустимый рейтинг. Разрешены значения от 1 до 5.");
    }

    public InvalidRatingException(String message) {
        super(message);
    }
}

