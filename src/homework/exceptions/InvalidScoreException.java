package homework.exceptions;

public class InvalidScoreException extends Exception {
    public InvalidScoreException() {
        super("Оценка должна быть от 1 до 5.");
    }

    public InvalidScoreException(String message) {
        super(message);
    }
}
