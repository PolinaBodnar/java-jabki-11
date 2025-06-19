package homework.exceptions;

public class LoginFailedException extends Exception {
    public LoginFailedException() {
        super("Ошибка входа: неверное имя пользователя или пароль.");
    }

    public LoginFailedException(String message) {
        super(message);
    }
}
