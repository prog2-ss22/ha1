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
    //First Green Test
    @Test
    @DisplayName("should display result after multiplying one two-digits-Numbers with one on-digit-number")
    void testMultiply() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();

        String expected = "80";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // first Red Test
    @Test
    @DisplayName("should display result of the square root of a negative number")
    void testFailNumber1() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        //calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Second Red Test
    @Test
    @DisplayName("should display result of dividing a number with zero")
    void testFailNumber2() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



}

