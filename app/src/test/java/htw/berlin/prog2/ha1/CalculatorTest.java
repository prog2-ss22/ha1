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

    //1. Teilaufgabe
    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //2. Teilaufgabe

    //1. rote Test
    @Test
    @DisplayName("should display  Error String if a number is divided by 0")
    void testDivisionNull() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "ERROR";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //2. rote Test

    @Test
    @DisplayName("should display  be one dot")
    void testDotKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressDotKey();

        String expected = "7.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }




}

