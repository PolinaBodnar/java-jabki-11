package homework.exceptions;

public class InvalidRatingException extends Exception {
    public InvalidRatingException(int rating) {
        super("Недопустимый рейтинг: " + rating + ". Допустимы значения от 1 до 5.");
    }
}

