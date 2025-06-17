package homework.Tests;

import homework.exceptions.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Безопасное деление
        System.out.println("1. Безопасное деление:");
        System.out.println("Результат: " + Tests.safeDivide(1, 0));
        System.out.println("Результат: " + Tests.safeDivide(0, 0));
        System.out.printf("10 / 2 = %d%n%n", Tests.safeDivide(10, 2));

        // 2. Проверка строки
        System.out.println("2. Проверка строки:");
        try {
            Tests.validateString("    ");
        } catch (IllegalArgumentException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Tests.validateString("Текст");
            System.out.println("Строка корректна");
        } catch (IllegalArgumentException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.println();

        // 3. Преобразование строки в число
        System.out.println("3. Преобразование строки в число:");
        List<Integer> numbers = Tests.convertStringToNum(List.of("155", "two", "9", "12q", "-47"));
        System.out.printf("Преобразованные числа: %s%n%n", numbers);

        // 4. Простая валидация возраста
        System.out.println("4. Простая валидация возраста:");
        Tests.setAge(0);
        Tests.setAge(25);
        try {
            System.out.println(Tests.setAge(-1));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();

        // 5. Депозит с собственным исключением
        System.out.println("5. Собственное исключение: депозит");
        try {
            Tests.deposit(-1);
        } catch (BadDepositException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Tests.deposit(0);
        } catch (BadDepositException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Tests.deposit(300);
        } catch (BadDepositException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.println();

        // 6. Поиск товара по коду
        System.out.println("6. Поиск товара по коду:");
        try {
            System.out.printf("Товар с кодом 123: %s%n", Tests.getItem("123"));
            System.out.printf("Товар с кодом 999: %s%n", Tests.getItem("999"));
        } catch (UnknownProductCodeException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.println();

        // 7. Чтение из файла
        System.out.println("7. Чтение из файла:");
        List<String> lines = Tests.readFile("file.txt");
        System.out.printf("Прочитанные строки: %s%n%n", lines);

        // 8. Система логина
        System.out.println("8. Система логина:");
        try {
            Tests.login("admin", "pass");
        } catch (LoginException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Tests.login("admin", "1234");
        } catch (LoginException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.println();

        // 9. Банковский перевод с валидацией
        System.out.println("9. Банковский перевод:");
        double from = 100.0;
        double to = 50.0;
        try {
            double[] res = Tests.transfer(from, to, 30.0);
            from = res[0];
            to = res[1];
            Tests.transfer(from, to, 200.0);
        } catch (TransferRuleViolationException | NotEnoughFundsException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Tests.transfer(from, to, 0.0);
        } catch (TransferRuleViolationException | NotEnoughFundsException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Tests.transfer(from, to, -1.0);
        } catch (TransferRuleViolationException | NotEnoughFundsException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.printf("Баланс отправителя: %.2f%n", from);
        System.out.printf("Баланс получателя: %.2f%n%n", to);

        // 10. Сервис оценки товара
        System.out.println("10. Сервис оценки товара:");
        System.out.println(Tests.rateProduct("5"));
        System.out.println(Tests.rateProduct("abc"));
        System.out.println(Tests.rateProduct("7"));
        System.out.println(Tests.rateProduct("0"));
        try {
            System.out.println(Tests.rateProduct(3));
            System.out.println(Tests.rateProduct(6));
        } catch (InvalidScoreException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
    }
}
