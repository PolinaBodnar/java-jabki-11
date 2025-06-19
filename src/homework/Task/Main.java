package homework.Task;

import homework.exceptions.InvalidRatingException;
import homework.exceptions.ItemNotFoundException;
import homework.exceptions.LoginException;
import homework.exceptions.NegativeDepositException;
import homework.exceptions.NotEnoughFundsException;
import homework.exceptions.TransferRuleViolationException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Безопасное деление
        System.out.println("1. Безопасное деление:");
        System.out.println("Результат: " + Test.safeDivide(1, 0));
        System.out.println("Результат: " + Test.safeDivide(0, 0));
        System.out.printf("10 / 2 = %d%n%n", Test.safeDivide(10, 2));

        // 2. Проверка строки
        System.out.println("2. Проверка строки:");
        try {
            Test.validateString("    ");
        } catch (IllegalArgumentException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Test.validateString("Текст");
            System.out.println("Строка корректна");
        } catch (IllegalArgumentException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.println();

        // 3. Преобразование строки в число
        System.out.println("3. Преобразование строки в число:");
        List<Integer> numbers = Test.convertStringToNum(List.of("1", "2", "a", "3"));
        System.out.printf("Преобразованные числа: %s%n%n", numbers);

        // 4. Простая валидация возраста
        System.out.println("4. Простая валидация возраста:");
        Test.setAge(0);
        Test.setAge(25);
        try {
            System.out.println(Test.setAge(-1));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();

        // 5. Депозит с собственным исключением
        System.out.println("5. Собственное исключение: депозит");
        try {
            Test.deposit(-1);
        } catch (NegativeDepositException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Test.deposit(0);
        } catch (NegativeDepositException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Test.deposit(300);
        } catch (NegativeDepositException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.println();

        // 6. Поиск товара по коду
        System.out.println("6. Поиск товара по коду:");
        try {
            System.out.printf("Товар с кодом 123: %s%n", Test.getItem("123"));
        } catch (ItemNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            System.out.printf("Товар с кодом 999: %s%n", Test.getItem("999"));
        } catch (ItemNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();

        // 7. Чтение из файла
        System.out.println("7. Чтение из файла:");
        List<String> lines = Test.readFile("file.txt");
        System.out.printf("Прочитанные строки: %s%n%n", lines);

        // 8. Система логина
        System.out.println("8. Система логина:");
        try {
            Test.login("admin", "pass");
        } catch (LoginException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Test.login("admin", "1234");
        } catch (LoginException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.println();

        // 9. Банковский перевод с валидацией
        System.out.println("9. Банковский перевод:");
        double from = 100.0;
        double to = 50.0;
        try {
            double[] res = Test.transfer(from, to, 30.0);
            from = res[0];
            to = res[1];
            Test.transfer(from, to, 200.0);
        } catch (TransferRuleViolationException | NotEnoughFundsException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Test.transfer(from, to, 0.0);
        } catch (TransferRuleViolationException | NotEnoughFundsException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        try {
            Test.transfer(from, to, -1.0);
        } catch (TransferRuleViolationException | NotEnoughFundsException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
        System.out.printf("Баланс отправителя: %.2f%n", from);
        System.out.printf("Баланс получателя: %.2f%n%n", to);

        // 10. Сервис оценки товара
        System.out.println("10. Сервис оценки товара:");
        System.out.println(Test.rateProduct("5"));     // OK
        System.out.println(Test.rateProduct("abc"));   // NumberFormatException внутри метода
        System.out.println(Test.rateProduct("7"));     // InvalidRatingException внутри метода
        System.out.println(Test.rateProduct("0"));     // InvalidRatingException внутри метода
        try {
            System.out.println(Test.rateProduct(3));   // OK
            System.out.println(Test.rateProduct(6));   // InvalidRatingException
        } catch (InvalidRatingException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
