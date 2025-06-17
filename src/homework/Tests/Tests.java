package homework.Tests;

import homework.exceptions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Tests {

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
    public static void deposit(int amount) throws BadDepositException {
        if (amount <= 0) {
            throw new BadDepositException("Сумма депозита должна быть положительной.");
        }
        System.out.printf("Депозит успешен: %d%n", amount);
    }

    // 6. Поиск товара по коду
    public static String getItem(String code) throws UnknownProductCodeException {
        Map<String, String> items = Map.of(
                "123", "Телефон",
                "456", "Ноутбук",
                "789", "Планшет"
        );
        if (!items.containsKey(code)) {
            throw new UnknownProductCodeException("Товар с таким кодом не найден.");
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
    public static void login(String username, String password) throws LoginException {
        if (!"admin".equals(username) || !"1234".equals(password)) {
            throw new LoginException("Неверное имя пользователя или пароль.");
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

    // 10. Оценка товара (перегрузка)
    public static String rateProduct(String ratingStr) {
        try {
            int rating = Integer.parseInt(ratingStr);
            return rateProduct(rating);
        } catch (NumberFormatException e) {
            return "Некорректный формат оценки.";
        } catch (InvalidScoreException e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    public static String rateProduct(int rating) throws InvalidScoreException {
        if (rating < 1 || rating > 5) {
            throw new InvalidScoreException("Оценка должна быть от 1 до 5.");
        }
        return "Оценка принята: " + rating;
    }
}
