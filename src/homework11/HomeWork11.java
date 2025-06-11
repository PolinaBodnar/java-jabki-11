package homework11;

import java.io.*;
import java.util.*;

public class HomeWork11 {

    private static final List<Integer> ratings = new ArrayList<>();

    public static Integer safeDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.err.println("Деление на ноль запрещено");
            return null;
        }
    }

    public static void checkString(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой или пробельной");
        }
    }

    public static List<Integer> convertStringList(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (String s : list) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.err.println("Ошибка преобразования строки в число: " + s);
            }
        }
        return result;
    }

    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }

    public static void deposit(double amount) throws NegativeDepositException {
        if (amount <= 0) {
            throw new NegativeDepositException("Сумма депозита должна быть больше нуля");
        }
    }

    public static String getItem(String code) {
        Map<String, String> items = Map.of("Блокнот", "Notebook", "Ручка", "Pen");
        if (!items.containsKey(code)) {
            throw new ItemNotFoundException("Товар с кодом '" + code + "' не найден");
        }
        return items.get(code);
    }

    public static void readFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void login(String username, String password) throws LoginFailedException {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            throw new IllegalArgumentException("Логин и пароль не могут быть пустыми");
        }

        if (!"admin".equals(username) || !"qwerty".equals(password)) {
            throw new LoginFailedException("Неверный логин или пароль");
        }
    }

    public static void transfer(double fromAccount, double toAccount, double amount)
            throws InvalidTransferAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidTransferAmountException("Сумма должна быть положительной");
        }
        if (fromAccount < amount) {
            throw new InsufficientBalanceException("Недостаточно средств");
        }
        System.out.println("Перевод выполнен");
    }

    public static void rateProduct(String input) throws InvalidRatingException {
        int rating;
        try {
            rating = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Некорректный формат рейтинга: должно быть число от 1 до 5");
        }

        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException("Рейтинг должен быть от 1 до 5");
        }

        ratings.add(rating);
        System.out.println("Рейтинг сохранён: " + rating);
    }

    public static List<Integer> getRatings() {
        return new ArrayList<>(ratings);
    }
}
