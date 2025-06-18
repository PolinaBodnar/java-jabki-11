package homework.exceptions;

public class LoginException extends Exception {
    public LoginException() {
        super("Ошибка входа: неверное имя пользователя или пароль.");
    }
}
