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

    /**
     * addieren von zwei Zahlen vom Datentypen Double
     */
    @Test
    @DisplayName("should display result after add two double numbers")
    void testPositivSubtraction() {

        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();
        calc.pressDotKey();
        calc.pressDigitKey(0);


        String expected = "10.0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


/**
    //Aufgabe 2
    @Test
    @DisplayName("Division")
    void testPositivDivision() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressUnaryOperationKey("1/x");


        String expected = "0.33333333";
        String actual = calc.readScreen();


        assertEquals(expected, actual);
    }

    /**
     * Eine mathematische Regel besagt das nicht durch Null dividiert werden darf
     * bei der Division mit Null ein Error


    @Test
    @DisplayName("es sollte bei der Division durch Null ein Error ausgeben werden")
    void testDivisionDurchNull(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();


        assertEquals(expected, actual);
    }

    /**
     * In der Mathematik kann aus einer negativen Zahl keine Wurzel gezogen werden
     * bei dem online Calculator wird ein Error bei der Rechnung mit einer negativen Zahl ausgegeben


    @Test
    @DisplayName("Wurzel aus einer Minus zahl")
    void testNegativeWurzel(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();


        assertEquals(expected, actual);
    }*/





}