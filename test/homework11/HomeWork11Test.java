package homework11;

import homework11.exception.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeWork11Test {

    @Test void testSafeDivideValid() { assertEquals(5, HomeWork11.safeDivide(10, 2)); }
    @Test void testSafeDivideByZero() { assertEquals(0, HomeWork11.safeDivide(10, 0)); }
    @Test void testCheckStringInvalid() { assertThrows(IllegalArgumentException.class, () -> HomeWork11.checkString("   ")); }
    @Test void testConvertStringList() {
        List<String> input = List.of("10", "abc", "5");
        List<Integer> expected = List.of(10, 5);
        assertEquals(expected, HomeWork11.convertStringList(input));
    }
    @Test void testSetAgeNegative() { assertThrows(IllegalArgumentException.class, () -> HomeWork11.setAge(-5)); }
    @Test void testDepositNegative() { assertThrows(NegativeDepositException.class, () -> HomeWork11.deposit(-100)); }
    @Test void testGetItemFound() throws ItemNotFoundException {
        assertEquals("Альбом", HomeWork11.getItem("Альбом"));
    }
    @Test void testGetItemNotFound() { assertThrows(ItemNotFoundException.class, () -> HomeWork11.getItem("Книга")); }
    @Test void testLoginInvalid() { assertThrows(Exception.class, () -> HomeWork11.login("admin", "")); }
    @Test void testTransferInvalidAmount() {
        assertThrows(InvalidTransferAmountException.class, () -> HomeWork11.transfer(500, 1000, 0));
    }
    @Test void testTransferInsufficientBalance() {
        assertThrows(InsufficientBalanceException.class, () -> HomeWork11.transfer(100, 200, 300));
    }
    @Test void testRateProductInvalid() {
        assertThrows(Exception.class, () -> HomeWork11.rateProduct("6"));
    }
    @Test void testRateProductValid() throws Exception {
        HomeWork11.rateProduct("5");
        assertTrue(HomeWork11.getRatings().contains(5));
    }
}
