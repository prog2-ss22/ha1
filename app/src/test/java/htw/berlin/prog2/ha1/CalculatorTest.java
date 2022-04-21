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
   // @Test
    //@DisplayName("should display result after getting the square root of two")
    //void testDotKey() {
   //Calculator calc = new Calculator();

        //calc.pressDigitKey(8);
       // calc.pressDotKey();
      //  calc.pressDigitKey(4);
      //  calc.pressUnaryOperationKey("1/x");
        //String expected = "0.11904762"; //0.11904762 über des Online-Rechners
       // String actual = calc.readScreen();

       // assertEquals(expected, actual);
    //}

    //Teilaufgabe 2 und 3
    @Test
    @DisplayName("should display result after getting the square root of two")
    void testPercentage() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("%");

        String expected = "0.1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after getting the square root of two")
    void testDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(1);
        calc.pressDigitKey(7);

        calc.pressEqualsKey();

        String expected = "3,82352941";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}