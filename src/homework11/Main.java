package homework11;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 1. Безопасное деление
        System.out.println("Результат деления: " + HomeWork11.safeDivide(10, 2));
        System.out.println("Результат деления: " + HomeWork11.safeDivide(10, 0));

        // 2. Проверка строки
        try {
            HomeWork11.checkString("  ");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка строки: " + e.getMessage());
        }

        // 3. Преобразование строки в числа
        List<String> raw = List.of("10", "abc", "5");
        List<Integer> numbers = HomeWork11.convertStringList(raw);
        System.out.println("Числа: " + numbers);

        // 4. Проверка возраста
        try {
            HomeWork11.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка возраста: " + e.getMessage());
        }

        // 5. Попытка внести депозит
        try {
            HomeWork11.deposit(-100);
        } catch (NegativeDepositException e) {
            System.out.println("Ошибка депозита: " + e.getMessage());
        }

        // 6. Поиск товара
        try {
            String item = HomeWork11.getItem("Альбом");
            System.out.println("Товар найден: " + item);
        } catch (ItemNotFoundException e) {
            System.out.println("Ошибка поиска товара: " + e.getMessage());
        }

        // 7. Чтение файла
        try {
            HomeWork11.readFile("src/homework11/testFile.txt");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        // 8. Вход в систему
        try {
            HomeWork11.login("admin", "");
        } catch (Exception e) {
            System.out.println("Ошибка логина: " + e.getMessage());
        }

        // 9. Перевод средств
        try {
            HomeWork11.transfer(500, 1000, 0);
        } catch (InvalidTransferAmountException | InsufficientBalanceException e) {
            System.out.println("Ошибка перевода: " + e.getMessage());
        }

        // 10. Оценка товара
        try {
            HomeWork11.rateProduct("6");
        } catch (Exception e) {
            System.out.println("Ошибка рейтинга: " + e.getMessage());
        }

        try {
            HomeWork11.rateProduct("5");
            System.out.println("Текущие оценки: " + HomeWork11.getRatings());
        } catch (Exception e) {
            System.out.println("Ошибка рейтинга: " + e.getMessage());
        }
    }
}
