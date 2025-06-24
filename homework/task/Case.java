package homework.task;

import homework.exception.InvalidRatingException;
import homework.exception.InvalidTransferAmountException;
import homework.exception.InsufficientBalanceException;
import homework.exception.ItemNotFoundException;
import homework.exception.NegativeDepositException;
import homework.exception.LoginException;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Case {

    private static final List<Integer> ratings = new ArrayList<>();

    private static final Map<String, String> ITEMS = Map.of(
            "123", "Телефон",
            "456", "Ноутбук",
            "789", "Планшет"
    );

    // 1. Безопасное деление
    public static int safeDivide(int a, int b) {
        if (b == 0) {
            System.out.println("Деление на ноль невозможно.");
            return 0;
        }
        return a / b;
    }

    // 2. Проверка строки
    public static void validateString(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой или состоять из пробелов.");
        }
    }

    // 3. Преобразование строки в число
    public static List<Integer> convertStringToNum(List<String> strings) {
        List<Integer> result = new ArrayList<>();
        for (String s : strings) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.printf("Невозможно преобразовать '%s' в число.%n", s);
            }
        }
        return result;
    }

    // 4. Валидация возраста
    public static String setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше нуля");
        }
        return String.format("Возраст установлен: %d", age);
    }

    // 5. Депозит
    public static String deposit(int amount) throws NegativeDepositException {
        if (amount <= 0) {
            throw new NegativeDepositException("Сумма депозита должна быть положительной.");
        }
        return String.format("Депозит успешен: %d", amount);
    }

    // 6. Поиск товара по коду
    public static String getItem(String code) throws ItemNotFoundException {
        if (!ITEMS.containsKey(code)) {
            throw new ItemNotFoundException(code);
        }
        return ITEMS.get(code);
    }

    // 7. Чтение файла
    public static List<String> readFile(String filename) {
        try {
            return Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    // 8. Система логина
    public static String login(String username, String password) throws LoginException {
        if (!"admin".equals(username) || !"1234".equals(password)) {
            throw new LoginException("Неверный логин или пароль.");
        }
        return "Успешный вход";
    }

    // 9. Перевод средств
    public static double[] transfer(double from, double to, double amount)
            throws InvalidTransferAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidTransferAmountException("Сумма перевода должна быть положительной.");
        }
        if (from < amount) {
            throw new InsufficientBalanceException("Недостаточно средств для перевода.");
        }
        from -= amount;
        to += amount;
        System.out.printf("Перевод %.2f завершён успешно.%n", amount);
        return new double[]{from, to};
    }

    // 10. Сервис оценки товара
    public static String rateProduct(int rating) throws InvalidRatingException {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException(rating);
        }
        ratings.add(rating);
        return String.format("Рейтинг успешно сохранён: %d", rating);
    }

    public static String rateProduct(String ratingStr) {
        try {
            int rating = Integer.parseInt(ratingStr);
            return rateProduct(rating);
        } catch (NumberFormatException e) {
            return String.format("Рейтинг %s не является числом", ratingStr);
        } catch (InvalidRatingException e) {
            return e.getMessage();
        }
    }
}