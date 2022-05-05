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
    //Teilaufgabe 1
    @Test
    @DisplayName("should display result after getting the square root of two")
    void testNegativeOperation() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(6);
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "22";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Zusätzliche Tests
    @Test
    @DisplayName("should display result after getting the square root of two")
    void testClearOperation() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(9);
        calc.pressEqualsKey();
        calc.pressClearKey();
        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after getting the square root of two")
    void testNegativeKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressNegativeKey();
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(7);
        calc.pressEqualsKey();
        String expected = "-63";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
//Teilaufgabe 2 rote Tests 2

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testDotKey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(8);
        calc.pressDotKey();
        calc.pressDigitKey(4);
        calc.pressUnaryOperationKey("1/x");
        String expected = "0.11904762"; //0.11904762 über des Online-Rechners
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after multiplying 3 digits.")
    void testMultiplikation() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "50";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
//Neuer roter Test
    @Test
    @DisplayName("should only show 9 digits.")
    void testScreen() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressDigitKey(3);
        calc.pressDigitKey(4);
        calc.pressDigitKey(5);
        calc.pressDigitKey(6);
        calc.pressDigitKey(7);
        calc.pressDigitKey(8);
        calc.pressDigitKey(9);
        calc.pressDigitKey(5);

        String expected = "123456789";

        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should only show 9 digits.")
    void testScreen2() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressDigitKey(8);
        calc.pressDigitKey(7);
        calc.pressDigitKey(6);
        calc.pressDigitKey(5);
        calc.pressDigitKey(4);
        calc.pressDigitKey(3);
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressDigitKey(1);

        String expected = "987654320";

        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



}