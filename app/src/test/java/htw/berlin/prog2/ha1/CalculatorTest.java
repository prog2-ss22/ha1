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
    @DisplayName("should display result after substracting two positive numbers")
    void testPositiveSubstraction(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display cleared screen")
    void testClearedScreen(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressClearKey();

        String expected = "0";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calc should ignore last dot on the screen")
    void testSecondDot(){

        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressDigitKey(9);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();

        String expected = "99.7";
        String actual = calc.readScreen();
        assertEquals(actual,expected);
    }

    @Test
    @DisplayName("calc should display an error when dividing with 0")
    void testDivisionNull(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

