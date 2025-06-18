package homework.Task;

import homework.exceptions.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    // 1. Безопасное деление
    @Test
    void testSafeDivide_normal() {
        Assertions.assertEquals(2, Test.safeDivide(10, 5));
    }

    @Test
    void testSafeDivide_byZero() {
        Assertions.assertEquals(0, Test.safeDivide(10, 0));
    }

    // 2. Проверка строки
    @Test
    void testValidateString_valid() {
        Assertions.assertDoesNotThrow(() -> Test.validateString("Тест"));
    }

    @Test
    void testValidateString_empty() {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> Test.validateString("  "));
        Assertions.assertTrue(e.getMessage().contains("не должна быть пустой"));
    }

    // 3. Преобразование строки в число
    @Test
    void testConvertStringToNum_valid() {
        List<String> input = List.of("1", "2", "3");
        List<Integer> result = Test.convertStringToNum(input);
        Assertions.assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void testConvertStringToNum_withInvalid() {
        List<String> input = List.of("1", "abc", "3");
        List<Integer> result = Test.convertStringToNum(input);
        Assertions.assertEquals(List.of(1, 3), result);
    }

    // 4. Проверка возраста
    @Test
    void testSetAge_valid() {
        Assertions.assertEquals(20, Test.setAge(20));
    }

    @Test
    void testSetAge_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Test.setAge(-5));
    }

    // 5. Депозит
    @Test
    void testDeposit_valid() throws BadDepositException {
        Assertions.assertDoesNotThrow(() -> Test.deposit(100));
    }

    @Test
    void testDeposit_invalid() {
        Assertions.assertThrows(BadDepositException.class, () -> Test.deposit(0));
    }

    // 6. Поиск товара
    @Test
    void testGetItem_valid() throws ItemNotFoundException {
        Assertions.assertEquals("Телефон", Test.getItem("123"));
    }

    @Test
    void testGetItem_invalid() {
        Assertions.assertThrows(ItemNotFoundException.class, () -> Test.getItem("000"));
    }

    // 7. Чтение файла
    @Test
    void testReadFile_nonexistent() {
        List<String> lines = Test.readFile("non_existing.txt");
        Assertions.assertTrue(lines.isEmpty());
    }

    // 8. Логин
    @Test
    void testLogin_valid() {
        Assertions.assertDoesNotThrow(() -> Test.login("admin", "1234"));
    }

    @Test
    void testLogin_invalid() {
        Assertions.assertThrows(LoginFailedException.class, () -> Test.login("user", "wrong"));
    }

    // 9. Перевод
    @Test
    void testTransfer_valid() throws TransferRuleViolationException, NotEnoughFundsException {
        double[] result = Test.transfer(100.0, 50.0, 20.0);
        Assertions.assertEquals(80.0, result[0]);
        Assertions.assertEquals(70.0, result[1]);
    }

    @Test
    void testTransfer_notEnoughFunds() {
        Assertions.assertThrows(NotEnoughFundsException.class, () -> Test.transfer(10.0, 50.0, 20.0));
    }

    @Test
    void testTransfer_invalidAmount() {
        Assertions.assertThrows(TransferRuleViolationException.class, () -> Test.transfer(100.0, 50.0, -5));
    }

    // 10. Оценка товара
    @Test
    void testRateProduct_validInt() throws InvalidRatingException {
        String response = Test.rateProduct(5);
        Assertions.assertTrue(response.contains("успешно"));
    }

    @Test
    void testRateProduct_invalidInt() {
        Assertions.assertThrows(InvalidRatingException.class, () -> Test.rateProduct(0));
    }

    @Test
    void testRateProduct_validString() {
        String response = Test.rateProduct("4");
        Assertions.assertTrue(response.contains("успешно"));
    }

    @Test
    void testRateProduct_invalidString() {
        String response = Test.rateProduct("abc");
        Assertions.assertTrue(response.contains("не является числом"));
    }

    @Test
    void testRateProduct_outOfRangeString() {
        String response = Test.rateProduct("6");
        Assertions.assertTrue(response.contains("Недопустимый рейтинг"));
    }
}
