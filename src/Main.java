import java.io.*;
import java.util.*;



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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 10. Оценка товара
        try {
            rateProduct("abc");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 1
    static void safeDivide(int a, int b) {
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль запрещено");
        }
    }

    // 2
    static void checkString(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой или пробельной");
        }
    }

    // 3
    static List<Integer> parseNumbers(List<String> list) {
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

    // 4
    static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }

    // 5
    static void deposit(double amount) throws NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException("Нельзя внести отрицательный депозит");
        }
    }

    // 6
    static void getItem(String code) {
        Map<String, String> items = Map.of("A1", "Яблоко", "B2", "Банан");
        if (!items.containsKey(code)) {
            throw new ItemNotFoundException("Товар с кодом " + code + " не найден");
        }
        System.out.println("Найден товар: " + items.get(code));
    }

    // 7
    static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    // 8
    static void login(String username, String password) throws LoginFailedException {
        if (!"admin".equals(username) || !"admin123".equals(password)) {
            throw new LoginFailedException("Неверный логин или пароль");
        }
        System.out.println("Успешный вход");
    }

    // 9
    static void transfer(double fromAccount, double toAccount, double amount)
            throws InvalidTransferAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidTransferAmountException("Сумма должна быть положительной");
        }
        if (fromAccount < amount) {
            throw new InsufficientBalanceException("Недостаточно средств");
        }
        System.out.println("Перевод выполнен");
    }

    // 10
    static List<Integer> ratings = new ArrayList<>();

    static void rateProduct(String input) throws InvalidRatingException {
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
