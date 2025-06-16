package homework11;

import homework11.exception.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HomeWork11 {

    private static List<Integer> ratings = new ArrayList<>();

    public static int safeDivide(int a, int b) {
        return b == 0 ? 0 : a / b;
    }

    public static void checkString(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой");
        }
    }

    public static List<Integer> convertStringList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String s : input) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException ignored) {}
        }
        return result;
    }

    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }

    public static void deposit(int amount) throws NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException("Сумма депозита не может быть отрицательной");
        }
    }

    public static String getItem(String name) throws ItemNotFoundException {
        if (!"Альбом".equals(name)) {
            throw new ItemNotFoundException("Товар не найден: " + name);
        }
        return name;
    }

    public static void readFile(String path) throws IOException {
        Files.readAllLines(Path.of(path));
    }

    public static void login(String user, String pass) throws Exception {
        if (user == null || user.isEmpty() || pass == null || pass.isEmpty()) {
            throw new Exception("Логин и пароль не должны быть пустыми");
        }
    }

    public static void transfer(int from, int to, int amount) throws InvalidTransferAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidTransferAmountException("Сумма должна быть положительной");
        }
        if (from < amount) {
            throw new InsufficientBalanceException("Недостаточно средств");
        }
    }

    public static void rateProduct(String ratingStr) throws Exception {
        int rating = Integer.parseInt(ratingStr);
        if (rating < 1 || rating > 5) {
            throw new Exception("Рейтинг должен быть от 1 до 5");
        }
        ratings.add(rating);
    }

    public static List<Integer> getRatings() {
        return ratings;
    }
}
