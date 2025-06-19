package homework.task;

import homework.exceptions.InvalidRatingException;
import homework.exceptions.ItemNotFoundException;
import homework.exceptions.LoginFailedException;
import homework.exceptions.NegativeDepositException;
import homework.exceptions.NotEnoughFundsException;
import homework.exceptions.TransferRuleViolationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Case {

    // 10. Оценка товара - константа (статическое поле)
    private static final List<Integer> ratings = new ArrayList<>();

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
    public static int setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным.");
        }
        System.out.printf("Возраст установлен: %d%n", age);
        return age;
    }

    // 5. Депозит
    public static void deposit(int amount) throws NegativeDepositException {
        if (amount <= 0) {
            throw new NegativeDepositException("Сумма депозита должна быть положительной.");
        }
        System.out.printf("Депозит успешен: %d%n", amount);
    }

    // 6. Поиск товара по коду
    public static String getItem(String code) throws ItemNotFoundException {
        Map<String, String> items = Map.of(
                "123", "Телефон",
                "456", "Ноутбук",
                "789", "Планшет"
        );
        if (!items.containsKey(code)) {
            throw new ItemNotFoundException();
        }
        return items.get(code);
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
    public static void login(String username, String password) throws LoginFailedException {
        if (!"admin".equals(username) || !"1234".equals(password)) {
            throw new LoginFailedException();
        }
        System.out.println("Успешный вход.");
    }

    // 9. Перевод средств
    public static double[] transfer(double from, double to, double amount)
            throws TransferRuleViolationException, NotEnoughFundsException {
        if (amount <= 0) {
            throw new TransferRuleViolationException("Сумма перевода должна быть положительной.");
        }
        if (from < amount) {
            throw new NotEnoughFundsException("Недостаточно средств для перевода.");
        }
        from -= amount;
        to += amount;
        System.out.printf("Перевод %.2f завершён успешно.%n", amount);
        return new double[]{from, to};
    }

    // Метод с int
    public static String rateProduct(int rating) throws InvalidRatingException {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException(rating);
        }
        ratings.add(rating);
        return "Рейтинг успешно сохранён: " + rating;
    }

    // Перегруженный метод со String
    public static String rateProduct(String ratingStr) {
        try {
            int rating = Integer.parseInt(ratingStr);
            return rateProduct(rating);
        } catch (NumberFormatException e) {
            return "Рейтинг '" + ratingStr + "' не является числом";
        } catch (InvalidRatingException e) {
            return e.getMessage();
        }
    }
}
