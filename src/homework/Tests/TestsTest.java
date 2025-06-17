package homework.Tests;

import homework.exceptions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestsTest {

    @Test
    void safeDivideTest() {
        assertEquals(5, Tests.safeDivide(10, 2));
        assertEquals(0, Tests.safeDivide(5, 0)); // возвращает 0 при делении на 0
        assertEquals(0, Tests.safeDivide(0, 0));
    }

    @Test
    void validateStringTest() {
        assertThrows(IllegalArgumentException.class, () -> Tests.validateString("    "));
        assertThrows(IllegalArgumentException.class, () -> Tests.validateString(""));
        assertDoesNotThrow(() -> Tests.validateString("Текст"));
    }

    @Test
    void convertStringToNumTest() {
        List<Integer> result = Tests.convertStringToNum(List.of("10", "two", "5", "-4", "12q"));
        assertEquals(List.of(10, 5, -4), result);
    }

    @Test
    void setAgeTest() {
        assertEquals(20, Tests.setAge(20));
        assertEquals(0, Tests.setAge(0));
        assertThrows(IllegalArgumentException.class, () -> Tests.setAge(-1));
    }

    @Test
    void depositTest() throws BadDepositException {
        assertDoesNotThrow(() -> Tests.deposit(100));
        assertThrows(BadDepositException.class, () -> Tests.deposit(0));
        assertThrows(BadDepositException.class, () -> Tests.deposit(-50));
    }

    @Test
    void getItemTest() {
        assertDoesNotThrow(() -> assertEquals("Телефон", Tests.getItem("123")));
        assertThrows(UnknownProductCodeException.class, () -> Tests.getItem("999"));
    }

    @Test
    void readFileTest() throws IOException {
        Path tempFile = Files.createTempFile("testfile", ".txt");
        Files.write(tempFile, List.of("строка1", "строка2", "строка3"));
        List<String> result = Tests.readFile(tempFile.toString());
        assertEquals(List.of("строка1", "строка2", "строка3"), result);
        Files.deleteIfExists(tempFile);

        List<String> fallback = Tests.readFile("non_existing_file.txt");
        assertTrue(fallback.isEmpty());
    }

    @Test
    void loginTest() {
        assertDoesNotThrow(() -> Tests.login("admin", "1234"));
        assertThrows(LoginException.class, () -> Tests.login("admin", "pass"));
    }

    @Test
    void transferTest() throws TransferRuleViolationException, NotEnoughFundsException {
        double[] res = Tests.transfer(100.0, 50.0, 30.0);
        assertArrayEquals(new double[]{70.0, 80.0}, res, 0.0001);
        assertThrows(TransferRuleViolationException.class, () -> Tests.transfer(100.0, 50.0, 0.0));
        assertThrows(TransferRuleViolationException.class, () -> Tests.transfer(100.0, 50.0, -1.0));
        assertThrows(NotEnoughFundsException.class, () -> Tests.transfer(20.0, 10.0, 50.0));
    }

    @Test
    void rateProductIntTest() throws InvalidScoreException {
        assertEquals("Оценка принята: 4", Tests.rateProduct(4));
        assertThrows(InvalidScoreException.class, () -> Tests.rateProduct(6));
        assertThrows(InvalidScoreException.class, () -> Tests.rateProduct(0));
        assertThrows(InvalidScoreException.class, () -> Tests.rateProduct(-1));
    }

    @Test
    void rateProductStringTest() {
        assertEquals("Оценка принята: 3", Tests.rateProduct("3"));
        assertEquals("Некорректный формат оценки.", Tests.rateProduct("7abc"));
        assertEquals("Ошибка: Оценка должна быть от 1 до 5.", Tests.rateProduct("0"));
        assertEquals("Ошибка: Оценка должна быть от 1 до 5.", Tests.rateProduct("6"));
    }
}
