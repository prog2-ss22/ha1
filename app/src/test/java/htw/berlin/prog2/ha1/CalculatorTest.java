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
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
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

    //TODO hier weitere Tests erstellen

    //Green Test
    @Test
    @DisplayName("should clear the screen")
    void testPressClearKey() {

        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressClearKey();
        String expected = "0";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

        System.out.println("ergebnis" + "=" + calc.readScreen());
    }
    //Red Test
    @Test
    @DisplayName("should display the point number correctly")
    void calculatorCanDoNumbersWithDots() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(8);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressDotKey();
        assertEquals("8.2", calc.readScreen());
    }
}

