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
    //Aufgabe 1
    @Test
    @DisplayName("should display percent result from the digit number five")

    void testPositivPercent(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("%");

        String expected = "0.05";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Aufgabe 2
    @Test
    @DisplayName("should display 'Error' after divide the digit number two by zero")

    void testDivideByZero(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();
        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //Aufgabe 2
    @Test
    @DisplayName("should display 'Error' after getting the square root of a negativ number")

    void negativSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }






}

