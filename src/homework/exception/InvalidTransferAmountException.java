package homework.exception;

public class InvalidTransferAmountException extends Exception {
  public InvalidTransferAmountException(double amount) {
    super("Сумма перевода должна быть положительной. Получено: " + amount);
  }
}