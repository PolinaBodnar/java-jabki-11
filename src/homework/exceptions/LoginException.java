package homework.exceptions;

public class LoginException extends Exception {
    public LoginException() {
        super("Неверное имя пользователя или пароль.");
    }
}
