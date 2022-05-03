package htw.berlin.prog2.ha1;

import org.checkerframework.common.value.qual.StaticallyExecutable;
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

    @Test
    @DisplayName("should display the result after dividing the numerator with the denominator")
    void testDivide(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should Display the result after subtracting one squareroot with another")
    void testSubtractSquareRoots(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressDigitKey(6);
        calc.pressUnaryOperationKey("√");
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(7);
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");
        calc.pressEqualsKey();

        String expected = "0.23251651";
        String actual = calc.readScreen();

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("should display the result after multiplying 2 numbers")
    void testMultiply(){
        Calculator calc = new Calculator();


        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "1e+16";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

}

