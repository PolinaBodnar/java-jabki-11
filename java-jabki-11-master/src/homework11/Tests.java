package homework11;

import java.io.*;
import java.util.*;

public class Tests {

    public static void safeDivide(int a, int b) {
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль запрещено");
        }
    }

    public static void checkString(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой или пробельной");
        }
    }

    public static List<Integer> parseNumbers(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (String s : list) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка преобразования: " + s);
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
        if (amount < 0) {
            throw new NegativeDepositException("Нельзя внести отрицательный депозит");
        }
    }

    public static void getItem(String code) {
        Map<String, String> items = Map.of("A1", "Apple", "B2", "Banana");
        if (!items.containsKey(code)) {
            throw new ItemNotFoundException("Товар с кодом " + code + " не найден");
        }
        System.out.println("Найден товар: " + items.get(code));
    }

    public static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public static void login(String username, String password) throws LoginFailedException {
        if (!"admin".equals(username) || !"admin123".equals(password)) {
            throw new LoginFailedException("Неверный логин или пароль");
        }
        System.out.println("Успешный вход");
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

    private static final List<Integer> ratings = new ArrayList<>();

    public static void rateProduct(String input) throws InvalidRatingException {
        try {
            int rating = Integer.parseInt(input);
            if (rating < 1 || rating > 5) {
                throw new InvalidRatingException("Рейтинг должен быть от 1 до 5");
            }
            ratings.add(rating);
            System.out.println("Рейтинг сохранён: " + rating);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Некорректный формат рейтинга");
        }
    }
}