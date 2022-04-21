package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "42";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }







    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
       void testPositivedividation() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers ")
    void testnegativedividation() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);

        String expected = "33";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }
}


