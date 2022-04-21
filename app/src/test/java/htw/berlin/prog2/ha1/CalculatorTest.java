package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    //changes neu

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

    //TODO hier weitere Tests erstellen!
    @Test
    @DisplayName("should display result after subtract two positive multi-digit numbers")
    void testsubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "10";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result of 500 1/x")
    void testpercentage() {
        Calculator calc = new Calculator();



        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");

        String expected = "5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should clear display")
    void testClear() {
        Calculator calc = new Calculator();



        calc.pressClearKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after multiply 2 negative digit numbers")
    void testminutimesminus() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressNegativeKey();

        calc.pressBinaryOperationKey("x");

        calc.pressDigitKey(5);
        calc.pressNegativeKey();



        calc.pressEqualsKey();

        String expected = "30";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after dividing by zero")
    void testdividedbyzero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);


        calc.pressBinaryOperationKey("/");

        calc.pressDigitKey(0);




        calc.pressEqualsKey();

        String expected = "ERROR";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



}

