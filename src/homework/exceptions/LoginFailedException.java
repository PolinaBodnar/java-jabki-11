package homework.exceptions;

public class LoginFailedException extends Exception {
    public LoginFailedException() {
        super("Неверное имя пользователя или пароль.");
    }

    public LoginFailedException(String message) {
        super(message);
    }
}
