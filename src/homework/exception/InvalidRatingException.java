package homework.exception;

public class InvalidRatingException extends Exception {
    public InvalidRatingException(int rating) {
        super("Недопустимый рейтинг: " + rating + ". Допустимые значения: от 1 до 5.");
    }
}