package homework11;

import homework11.Exeption.InsufficientBalanceException;
import homework11.Exeption.InvalidTransferAmountException;
import homework11.Exeption.ItemNotFoundException;
import homework11.Exeption.NegativeDepositException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class HomeWork11Test {

    @Test
    void testSafeDivideValid() {
        assertEquals(Optional.of(Optional.of(5)), HomeWork11.safeDivide(10, 2));
    }

    @Test
    void testSafeDivideByZero() {
        assertEquals(0, HomeWork11.safeDivide(10, 0)); // предполагается, что при делении на 0 возвращается 0
    }

    @Test
    void testCheckStringValid() {
        assertDoesNotThrow(() -> HomeWork11.checkString("valid"));
    }

    @Test
    void testCheckStringInvalid() {
        assertThrows(IllegalArgumentException.class, () -> HomeWork11.checkString("   "));
    }

    @Test
    void testConvertStringList() {
        List<String> input = List.of("10", "abc", "5");
        List<Integer> expected = List.of(10, 5); // предполагается, что некорректные строки пропускаются
        assertEquals(expected, HomeWork11.convertStringList(input));
    }

    @Test
    void testSetAgeValid() {
        assertDoesNotThrow(() -> HomeWork11.setAge(25));
    }

    @Test
    void testSetAgeNegative() {
        assertThrows(IllegalArgumentException.class, () -> HomeWork11.setAge(-5));
    }

    @Test
    void testDepositValid() {
        assertDoesNotThrow(() -> HomeWork11.deposit(100));
    }

    @Test
    void testDepositNegative() {
        assertThrows(NegativeDepositException.class, () -> HomeWork11.deposit(-100));
    }

    @Test
    void testGetItemFound() {
        assertDoesNotThrow(() -> {
            String item = HomeWork11.getItem("Альбом");
            assertNotNull(item);
        });
    }

    @Test
    void testGetItemNotFound() {
        assertThrows(ItemNotFoundException.class, () -> HomeWork11.getItem("Неизвестный"));
    }

    @Test
    void testReadFileExists() {
        assertDoesNotThrow(() -> HomeWork11.readFile("src/homework11/testFile.txt"));
    }

    @Test
    void testLoginInvalid() {
        assertThrows(Exception.class, () -> HomeWork11.login("admin", ""));
    }

    @Test
    void testTransferInvalidAmount() {
        assertThrows(InvalidTransferAmountException.class, () -> HomeWork11.transfer(500, 1000, 0));
    }

    @Test
    void testTransferInsufficientBalance() {
        assertThrows(InsufficientBalanceException.class, () -> HomeWork11.transfer(100, 200, 300));
    }

    @Test
    void testRateProductInvalid() {
        assertThrows(Exception.class, () -> HomeWork11.rateProduct("6")); // если 6 — невалидный рейтинг
    }

    @Test
    void testRateProductValid() {
        assertDoesNotThrow(() -> HomeWork11.rateProduct("5"));
    }

    @Test
    void testGetRatings() throws Exception {
        HomeWork11.rateProduct("5");
        List<Integer> ratings = HomeWork11.getRatings();
        assertTrue(ratings.contains(5));
    }
}
