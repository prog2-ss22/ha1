package htw.berlin.prog2.ha1;

import org.checkerframework.checker.units.qual.C;
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

    //TODO Aufgabe 1
    //Substraktion wird getestet
    @Test
    @DisplayName("should display result (6) after substracting 6 from 12 ")
    void testSubstraction(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();

        String expected = "6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //TODO Aufgabe 2
    @Test
    @DisplayName("should display result after substracting 50 percent from 50")
    void testPercentualSubstraction(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");
        calc.pressEqualsKey();

        String expected = "25";
        String actual = calc.readScreen();

        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("should display result after deviding 2.5 in 2")
    void test0division() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);

        String expected = "Error";
        calc.pressEqualsKey();

        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

