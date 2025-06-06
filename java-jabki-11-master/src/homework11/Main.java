package homework11;

import java.util.List;

import static homework11.Tests.*;

public class Main {
    public static void main(String[] args) {
        // 1. Безопасное деление
        safeDivide(10, 2);
        safeDivide(10, 0);

        // 2. Проверка строки
        try {
            checkString("  ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // 3. Преобразование строки в число
        List<String> raw = List.of("10", "abc", "5");
        List<Integer> numbers = parseNumbers(raw);
        System.out.println("Числа: " + numbers);

        // 4. Валидация возраста
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // 5. Депозит с исключением
        try {
            deposit(-100);
        } catch (NegativeDepositException e) {
            System.out.println(e.getMessage());
        }

        // 6. Поиск товара
        try {
            getItem("X100");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 7. Чтение файла
        readFile("nonexistent.txt");

        // 8. Логин
        try {
            login("admin", "1234");
        } catch (LoginFailedException e) {
            System.out.println(e.getMessage());
        }

        // 9. Перевод
        try {
            transfer(500, 1000, 600);
        } catch (InvalidTransferAmountException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        // 10. Оценка товара
        try {
            rateProduct("abc");
        } catch (InvalidRatingException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
