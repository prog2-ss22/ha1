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
    
    /**
     * PressDotKey Test
     * getestet, ob Dezimalzahlen im Taschenrechner
     * eingegeben werden können
     * Testergebnis ist grün, sprich expected und actual stimmen überein
     */


    @Test
    @DisplayName("should display decimal number")
    void testDotKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(4);

        String expected = "2.4";
        String actual = calc.readScreen(); //angezeigt was im Taschenrechner steht

        assertEquals(expected, actual);   //Überprüft, ob expected und actual übereinstimmen
    }
    @Test
    @DisplayName("should display number with opposite sign")
    void testNegativeKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressNegativeKey();

        String expected = "-2";
        String actual = calc.readScreen(); //angezeigt was im Taschenrechner steht

        assertEquals(expected, actual);   //Überprüft, ob expected und actual übereinstimmen
    }


}

