package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("1 Retro calculator")
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
    @DisplayName("should display result after multiplying two positive numbers")
    void testProdukt() {
        // Test Aufgabe 1
        Calculator calc = new Calculator();
        calc.pressDigitKey(0);
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(0);
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "9";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

   @Test
   @DisplayName("should display result after dividing any number with zero")
   void testDividieren() {
        // Test Aufgabe 2
       Calculator calc = new Calculator();
       calc.pressDigitKey(1);
       calc.pressDigitKey(0);
       calc.pressBinaryOperationKey("/");
       calc.pressDigitKey(0);
       calc.pressEqualsKey();

       String expected = "ERROR";
       String actual = calc.readScreen();

       assertEquals(expected, actual);
   }

    @Test
    @DisplayName("should display result after getting the square root of seven")
    void testRunden() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressUnaryOperationKey("√");

        String expected = "2.64575131106";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


}

