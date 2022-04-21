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

    // 1.
    @Test
    @DisplayName("should display result after converting a single-digit number into a percentage rate")
    void testPercentageRate() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("%");


        String expected = "0.02";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // 1.
    @Test
    @DisplayName("should display result after subtracting two negative single-digit numbers")
    void testNegativeSubtractionsecond() {
        Calculator calc = new Calculator();


        calc.pressDigitKey(2);
        calc.pressNegativeKey();
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "-4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    // 2.
    @Test
    @DisplayName("should display Error after 1/0")
    void testErrorOneDivisionZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



/*
//2

    @Test
    @DisplayName("should display -2, using binary operation key in the beginning to have a negative first digit key")
    void testNegativeError() {
        Calculator calc = new Calculator();

        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "-2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
*/


}

