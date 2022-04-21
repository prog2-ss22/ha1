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

    @Test
    @DisplayName("should display result after subtracting two positive multi-digit numbers")
    void testPositiveSubtraction()  {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "8";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display the result of the one value by the power of the following")
    void testPotenzen()  {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("^");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "8";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should display the natural Log Ln from the number")
    void testLnX()  {
        Calculator calc = new Calculator();

        calc.pressDigitKey(11);
        calc.pressUnaryOperationKey("ln");
        //calc.pressBinaryOperationKey("+");
        //calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "2.3978952727983707";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should allow to calculate with sin")
    void testSin()  {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressUnaryOperationKey("sin");
        calc.pressEqualsKey();

        String expected = "0.8414709848078965";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Should allow to calculate with pi")
    void testPi()  {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressPiKey();
        calc.pressEqualsKey();

        String expected = "6.283185307179586";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }





}

