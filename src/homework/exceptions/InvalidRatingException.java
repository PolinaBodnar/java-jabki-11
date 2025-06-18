package homework.exceptions;

public class InvalidRatingException extends Exception {
    public InvalidRatingException(int rating) {
        super("Недопустимый рейтинг: " + rating + ". Оценка должна быть от 1 до 5.");
    }
}