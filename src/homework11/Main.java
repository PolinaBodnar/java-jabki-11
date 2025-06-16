package homework11;

import java.io.IOException;
import java.util.List;
import homework11.exception.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Результат деления: " + HomeWork11.safeDivide(10, 2));
        System.out.println("Результат деления: " + HomeWork11.safeDivide(10, 0));

        try {
            HomeWork11.checkString("  ");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка строки: " + e.getMessage());
        }

        List<String> raw = List.of("10", "abc", "5");
        List<Integer> numbers = HomeWork11.convertStringList(raw);
        System.out.println("Числа: " + numbers);

        try {
            HomeWork11.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка возраста: " + e.getMessage());
        }

        try {
            HomeWork11.deposit(-100);
        } catch (NegativeDepositException e) {
            System.out.println("Ошибка депозита: " + e.getMessage());
        }

        try {
            String item = HomeWork11.getItem("Альбом");
            System.out.println("Товар найден: " + item);
        } catch (ItemNotFoundException e) {
            System.out.println("Ошибка поиска товара: " + e.getMessage());
        }

        try {
            HomeWork11.readFile("resources/testFile.txt");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        try {
            HomeWork11.login("admin", "");
        } catch (Exception e) {
            System.out.println("Ошибка логина: " + e.getMessage());
        }

        try {
            HomeWork11.transfer(500, 1000, 0);
        } catch (InvalidTransferAmountException | InsufficientBalanceException e) {
            System.out.println("Ошибка перевода: " + e.getMessage());
        }

        try {
            HomeWork11.rateProduct("6");
        } catch (Exception e) {
            System.out.println("Ошибка рейтинга: " + e.getMessage());
        }

        try {
            HomeWork11.rateProduct("5");
            System.out.println("Текущие оценки: " + HomeWork11.getRatings());
        } catch (Exception e) {
            System.out.println("Ошибка рейтинга: " + e.getMessage());
        }
    }
}
