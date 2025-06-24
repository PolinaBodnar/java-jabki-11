package homework.exception;

public class LoginException extends Exception {
    public LoginException() {
        super("Ошибка входа: неверное имя пользователя или пароль.");
    }

    public LoginException(String message) {
        super(message);
    }
}
