package homework.exception;

public class NegativeDepositException extends Exception {
    public NegativeDepositException(int amount) {
        super("Сумма депозита должна быть положительной. Получено: " + amount);
    }
}