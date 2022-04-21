package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Retro calculator")
class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    //-----------------------------------------------------------------------------------------
    // Addition
    //-----------------------------------------------------------------------------------------

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
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
    @DisplayName("should display result after adding one negative multi-digit to one positive multi-digit number")
    void testNegativeAdditionAlternative1() {
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressNegativeKey();            // -20
        calc.pressBinaryOperationKey("+");  // +
        calc.pressDigitKey(2);              // 20
        calc.pressDigitKey(0);
        calc.pressEqualsKey();              // = 0

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two negative multi-digit numbers")
    void testNegativeAdditionAlternative2() {

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressNegativeKey();            // -20
        calc.pressBinaryOperationKey("+");  // +
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressNegativeKey();            // -20
        calc.pressEqualsKey();              // = -40

        String expected = "-40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after adding two negative multi-digit numbers")
    void testFailureByAddition() {

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);              // 20
        calc.pressBinaryOperationKey("++"); // ++
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);              // 20

        assertThrows(IllegalArgumentException.class, () -> calc.pressEqualsKey());
    }

    //-----------------------------------------------------------------------------------------
    // Subtraction
    //-----------------------------------------------------------------------------------------

    @Test
    @DisplayName("should display result after subtracting two negative multi-digit numbers")
    void testPositiveSubtraction() {

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);              // 20
        calc.pressBinaryOperationKey("-");  // -
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);              // 20
        calc.pressEqualsKey();              // = 0

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //-----------------------------------------------------------------------------------------
    // Square Root
    //-----------------------------------------------------------------------------------------

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRootNegativeNumber() {

        calc.pressDigitKey(2);
        calc.pressNegativeKey();
        assertThrows(IllegalArgumentException.class, () -> calc.pressUnaryOperationKey("√"));
    }

    //test
    @Test
    @DisplayName("should display result after getting the square root of two")
    void testFailureSquareRoot() {
        calc.pressDigitKey(2);
        assertThrows(IllegalArgumentException.class, () -> calc.pressUnaryOperationKey("ERROR"));
    }


    //-----------------------------------------------------------------------------------------
    // Division
    //-----------------------------------------------------------------------------------------

    @Test
    @DisplayName("should display result after subtracting two negative multi-digit numbers")
    void testPositiveDivision() {

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);              // 20
        calc.pressNegativeKey();            // -20
        calc.pressBinaryOperationKey("/");  // /
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);              // 20
        calc.pressEqualsKey();              // = -1

        String expected = "-1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after subtracting two negative multi-digit numbers")
    void testPositiveDivisionAlternative2() {

        calc.pressDigitKey(0);              // 0
        calc.pressBinaryOperationKey("/");  // /
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);              // 20
        calc.pressEqualsKey();              // = 0

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after subtracting two negative multi-digit numbers")
    void testFailureDivisionByZero() {

        calc.pressDigitKey(2);              // 2
        calc.pressBinaryOperationKey("/");  // /
        calc.pressDigitKey(0);              // 0
        assertThrows(IllegalArgumentException.class, () -> calc.pressEqualsKey());

    }

    @Test
    @DisplayName("should display result after one negative multi-digit to one positive multi-digit number")
    void testDotkey() {
        calc.pressDigitKey(2);
        calc.pressDotKey();    // 2.5
        calc.pressDigitKey(5);
        String expected = "2.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

