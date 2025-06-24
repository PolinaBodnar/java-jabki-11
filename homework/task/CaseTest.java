package homework.task;

import homework.exception.InvalidRatingException;

import homework.exception.InvalidTransferAmountException;
import homework.exception.InsufficientBalanceException;

import homework.exception.ItemNotFoundException;
import homework.exception.NegativeDepositException;
import homework.exception.LoginException;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaseTest {

    // 1. Безопасное деление
    @Test
    void testSafeDivide_normal() {
        assertEquals(2, Case.safeDivide(10, 5));
    }

    @Test
    void testSafeDivide_byZero() {
        assertEquals(0, Case.safeDivide(10, 0));
    }

    // 2. Проверка строки
    @Test
    void testValidateString_valid() {
        assertDoesNotThrow(() -> Case.validateString("Тест"));
    }

    @Test
    void testValidateString_empty() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Case.validateString("  "));
        assertTrue(e.getMessage().contains("не должна быть пустой"));
    }

    // 3. Преобразование строки в число
    @Test
    void testConvertStringToNum_valid() {
        List<String> input = List.of("1", "2", "3");
        List<Integer> result = Case.convertStringToNum(input);
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void testConvertStringToNum_withInvalid() {
        List<String> input = List.of("1", "abc", "3");
        List<Integer> result = Case.convertStringToNum(input);
        assertEquals(List.of(1, 3), result);
    }

    // 4. Проверка возраста
    @Test
    void testSetAge_valid() {
        assertEquals("Возраст установлен: 20", Case.setAge(20));
    }

    @Test
    void testSetAge_negative() {
        assertThrows(IllegalArgumentException.class, () -> Case.setAge(-5));
    }

    // 5. Депозит
    @Test
    void testDeposit_valid() {
        assertDoesNotThrow(() -> Case.deposit(100));
    }

    @Test
    void testDeposit_invalid() {
        assertThrows(NegativeDepositException.class, () -> Case.deposit(0));
    }

    // 6. Поиск товара
    @Test
    void testGetItem_valid() throws ItemNotFoundException {
        assertEquals("Телефон", Case.getItem("123"));
    }

    @Test
    void testGetItem_invalid() {
        assertThrows(ItemNotFoundException.class, () -> Case.getItem("000"));
    }

    // 7. Чтение файла
    @Test
    void testReadFile_nonexistent() {
        List<String> lines = Case.readFile("non_existing.txt");
        assertTrue(lines.isEmpty());
    }

    // 8. Логин
    @Test
    void testLogin_valid() {
        assertDoesNotThrow(() -> Case.login("admin", "1234"));
    }

    @Test
    void testLogin_invalid() {
        assertThrows(LoginException.class, () -> Case.login("user", "wrong"));
    }

    // 9. Оценка товара
    @Test
    void testRateProduct_validInt() throws InvalidRatingException {
        String response = Case.rateProduct(5);
        assertTrue(response.contains("успешно"));
    }

    @Test
    void testRateProduct_invalidInt() {
        assertThrows(InvalidRatingException.class, () -> Case.rateProduct(0));
    }

    @Test
    void testRateProduct_validString() {
        String response = Case.rateProduct("4");
        assertTrue(response.contains("успешно"));
    }

    @Test
    void testRateProduct_invalidString() {
        String response = Case.rateProduct("abc");
        assertTrue(response.contains("не является числом"));
    }

    @Test
    void testRateProduct_outOfRangeString() {
        String response = Case.rateProduct("6");
        assertTrue(response.contains("Рейтинг должен быть от 1 до 5"));
    }
}

