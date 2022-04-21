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

    // grüner Test Teilaufgabe 1
    @Test
    @DisplayName("should clear screen after pressing clear button")
    void testClearScreen() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressClearKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // roter test 1 Teilaufgabe 2 (jetzt grün)
    @Test
    @DisplayName("should display result after subtracting two negative multi-digit numbers")
    void testNegativeSubtract() {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        System.out.println(calc.readScreen());
        calc.pressDigitKey(1);
        System.out.println(calc.readScreen());
        calc.pressDigitKey(0);
        System.out.println(calc.readScreen());
        calc.pressBinaryOperationKey("-");
        System.out.println(calc.readScreen());
        calc.pressDigitKey(3);
        System.out.println(calc.readScreen());
        calc.pressEqualsKey();

        String expected = "-13";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // roter test 2 Teilaufgabe 2 (jetzt grün)
    @Test
    @DisplayName("should display result after dividing three positive multi-digit numbers")
    void testPositiveTripleDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /* @Test
    @DisplayName("same digits multiple ties")
    void testSameMultipleDigits() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        System.out.println(calc.readScreen());
        calc.pressDigitKey(5);
        System.out.println(calc.readScreen());
        calc.pressDigitKey(5);
        System.out.println(calc.readScreen());


        String expected = "555";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("dot")
    void testDot() {
        Calculator calc = new Calculator();

        calc.pressDotKey();

        String expected = "0.";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
     */
}
