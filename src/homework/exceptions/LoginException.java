package homework.exceptions;

public class LoginException extends Exception {
    public LoginException() {
        super("Ошибка входа: неверный логин или пароль.");
    }

    public LoginException(String message) {
        super(message);
    }
}
