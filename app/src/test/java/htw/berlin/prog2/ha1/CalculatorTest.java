package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("My Retro calculator")
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

    @Test
    @DisplayName("should display result after subtracting one number from another with the first number > second number")
    void testPositiveSubtraction(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "72";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after multiplying two digit numbers with usage of negative Key Button in front of the first number")
    void testNegativeKeyFirstMultiplication(){
        Calculator calc = new Calculator();
        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);

        calc.pressEqualsKey();

        String expected = "-44";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding 3 different summands")
    void testThreePositiveAdditions(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after using negative Key Button in front of the first number")
    void testNegativeKey(){
        Calculator calc = new Calculator();
        calc.pressNegativeKey();
        calc.pressDigitKey(2);
       // calc.pressBinaryOperationKey("+");
       // calc.pressDigitKey(0);

        calc.pressEqualsKey();

        String expected = "-2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display the typed in number as result when not using any Operators")
    void testEqualsWithoutOperator(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);

        calc.pressEqualsKey();

        String expected = "9";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

