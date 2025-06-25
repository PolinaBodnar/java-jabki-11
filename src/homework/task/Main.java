package homework.task;

import homework.exception.InvalidRatingException;
import homework.exception.InvalidTransferAmountException;
import homework.exception.InsufficientBalanceException;
import homework.exception.ItemNotFoundException;
import homework.exception.NegativeDepositException;
import homework.exception.LoginFailedException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Безопасное деление
        System.out.println("1. Безопасное деление:");
        System.out.println("Результат: " + Case.safeDivide(1, 0));
        System.out.println("Результат: " + Case.safeDivide(0, 0));
        System.out.printf("10 / 2 = %d%n%n", Case.safeDivide(10, 2));

        // 2. Проверка строки
        System.out.println("2. Проверка строки:");
        try {
            Case.validateString("    ");
        } catch (IllegalArgumentException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Case.validateString("Текст");
            System.out.println("Строка корректна");
        } catch (IllegalArgumentException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.println();

        // 3. Преобразование строки в число
        System.out.println("3. Преобразование строки в число:");
        List<Integer> numbers = Case.convertStringToNum(List.of("1", "2", "a", "3"));
        System.out.printf("Преобразованные числа: %s%n%n", numbers);

        // 4. Простая валидация возраста
        System.out.println("4. Простая валидация возраста:");
        try {
            System.out.println(Case.setAge(0));
            System.out.println(Case.setAge(25));
            System.out.println(Case.setAge(-1)); // вызовет исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();

        // 5. Депозит с собственным исключением
        System.out.println("5. Депозит:");
        for (int amount : new int[]{-1, 0, 300}) {
            try {
                System.out.println(Case.deposit(amount));
            } catch (NegativeDepositException e) {
                System.out.printf("Ошибка: %s%n", e.getMessage());
            }
        }
        System.out.println();

        // 6. Поиск товара по коду
        System.out.println("6. Поиск товара по коду:");
        for (String code : List.of("123", "999")) {
            try {
                System.out.printf("Товар с кодом %s: %s%n", code, Case.getItem(code));
            } catch (ItemNotFoundException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        System.out.println();

        // 7. Чтение из файла
        System.out.println("7. Чтение из файла:");
        List<String> lines = Case.readFile("file.txt");
        if (!lines.isEmpty()) {
            System.out.printf("Прочитанные строки: %s%n%n", lines);
        } else {
            System.out.println("Файл не найден или ошибка при чтении.\n");
        }

        // 8. Система логина
        System.out.println("8. Система логина:");

        List<String[]> loginAttempts = List.of(
                new String[]{"admin", "pass"},
                new String[]{"admin", "1234"}
        );

        for (String[] credentials : loginAttempts) {
            String username = credentials[0];
            String password = credentials[1];

            try {
                String result = Case.login(username, password);
                System.out.println(result);
            } catch (LoginFailedException e) {
                System.out.printf("Ошибка: %s%n", e.getMessage());
            }
        }

        System.out.println();

        // 9. Банковский перевод с валидацией
        System.out.println("9. Банковский перевод:");
        double from = 100.0;
        double to = 50.0;

        for (double amount : new double[]{30.0, 200.0, 0.0, -1.0}) {
            try {
                double[] res = Case.transfer(from, to, amount);
                from = res[0];
                to = res[1];
            } catch (InvalidTransferAmountException | InsufficientBalanceException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        System.out.printf("Баланс отправителя: %.2f%n", from);
        System.out.printf("Баланс получателя: %.2f%n%n", to);

        // 10. Сервис оценки товара
        try {
            System.out.println(Case.rateProduct(1));
            System.out.println(Case.rateProduct(9)); // выбросит исключение
        } catch (InvalidRatingException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
    }
}