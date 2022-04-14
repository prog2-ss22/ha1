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

    //Teilaufgabe 1: Schreiben Sie einen neuen zusätzlichen Test, der eine bisher nicht getestete
    // Funktionalität abdeckt, die bereits funktioniert und der daher direkt grün wird.

    @Test
    @DisplayName("should display result after dividing ten by one hundred")

    void testDividingByHundred(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");

        String expected = "0.1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("should display result after dividing by 0 (Error)")

    void testDividingBy0(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();


        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("should display result after dividing by 1/x if x is 0 (Error) ")

    void testNewTwo(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");


        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);


    }






}

