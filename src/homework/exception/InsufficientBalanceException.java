package homework.exception;

public class InsufficientBalanceException extends Exception {
  public InsufficientBalanceException(double balance, double required) {
    super("Недостаточно средств: баланс " + balance + ", требуется " + required);
  }
}