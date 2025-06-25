package homework.exception;

public class LoginException extends Exception {
    public LoginException(String username) {
        super("Ошибка входа: пользователь '" + username + "' не найден или пароль неверен.");
    }
}
