package homework.task;

import homework.exception.InvalidRatingException;
import homework.exception.InvalidTransferAmountException;
import homework.exception.InsufficientBalanceException;
import homework.exception.ItemNotFoundException;
import homework.exception.NegativeDepositException;
import homework.exception.LoginFailedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Case {

    private static final List<Integer> ratings = new ArrayList<>();

    private static final Map<String, String> ITEMS = Map.of(
            "123", "Телефон",
            "456", "Ноутбук",
            "789", "Планшет"
    );

    public static int safeDivide(int a, int b) {
        if (b == 0) {
            System.out.println("Деление на ноль невозможно.");
            return 0;
        }
        return a / b;
    }

    public static void validateString(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой или состоять из пробелов.");
        }
    }

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

    public static String setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше нуля");
        }
        return String.format("Возраст установлен: %d", age);
    }

    public static String deposit(int amount) throws NegativeDepositException {
        if (amount <= 0) {
            throw new NegativeDepositException(amount);
        }
        return String.format("Депозит успешен: %d", amount);
    }

    public static String getItem(String code) throws ItemNotFoundException {
        if (!ITEMS.containsKey(code)) {
            throw new ItemNotFoundException(code);
        }
        return ITEMS.get(code);
    }

    public static List<String> readFile(String filename) {
        try {
            return Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public static String login(String username, String password) throws LoginFailedException {
        if (!"admin".equals(username) || !"1234".equals(password)) {
            throw new LoginFailedException("Неверный логин или пароль.");
        }
        return "Успешный вход";
    }

    public static double[] transfer(double from, double to, double amount)
            throws InvalidTransferAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidTransferAmountException(amount);
        }
        if (from < amount) {
            throw new InsufficientBalanceException(from, amount);
        }
        from -= amount;
        to += amount;
        System.out.printf("Перевод %.2f завершён успешно.%n", amount);
        return new double[]{from, to};
    }

    public static String rateProduct(int rating) throws InvalidRatingException {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException(rating);
        }
        ratings.add(rating);
        return String.format("Рейтинг успешно сохранён: %d", rating);
    }
}


