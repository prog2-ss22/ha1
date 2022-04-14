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

    /** My Solutions
     *
     */

    /** T1)
    *       Schreiben Sie einen neuen zusätzlichen Test,
    *       der eine bisher nicht getestete Funktionalität abdeckt,
    *       die bereits funktioniert und der daher direkt grün wird.
    */

    /** testNegativeAddition
     *  This test tests, whether the calculator calculate a subtraction correctly.
     *
     *  result: Check
     */
    @Test
    @DisplayName("should display a result after subtraction")
    void testNegativeAddition() {
        Calculator calculator = new Calculator();

        calculator.pressDigitKey(5);
        calculator.pressBinaryOperationKey("-");
        calculator.pressDigitKey(3);
        calculator.pressEqualsKey();

        String expected = "2";
        String actual = calculator.readScreen();

        assertEquals(expected, actual);
    }

    /** T2)
     *      Schreiben Sie zwei weitere zusätzliche Tests,
     *      die zwei unterschiedliche Fehlerkategorien aufdecken
     *      (d.h. deren Fehlerursachen in unterschiedlichen Methoden liegen)
     *      und somit fehlschlagen.
     */

    /** (1/2) testOneTimeClearAddition
     *  This test tests, whether the pressClearKey()-method works correctly as described in the JavaDocs.
     *
     *  Scenario:   5 - (clear the "-") + 3 =
     *  expected:   5 + 3 = [8]
     *  actual:     3 (removes all and set the screen to 0)
     *
     *  result:     org.opentest4j.AssertionFailedError: expected: <8> but was: <3>
     */
    @Test
    @DisplayName("should display a addition after one-time-clear-operation")
    void testOneTimeClearAddition() {
        Calculator calculator = new Calculator();

        calculator.pressDigitKey(5);
        calculator.pressBinaryOperationKey("-");
        calculator.pressClearKey();
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(3);
        calculator.pressEqualsKey();

        String expected = "8";
        String actual = calculator.readScreen();

        assertEquals(expected, actual);
    }

    /** (2/2) testOneTimeClearAddition
     *  This test tests, how the calculator works with duplicated dot-inputs
     *  (Online-Calculator works like this: 5.5.5 => 5.55)
     *
     *  Scenario:   5 . 5 . (should be removed) 5 + 0 5 5  =
     *  expected:   5.55 + 0.55 = 6.1
     *  actual:     5.5.5 + 0.55 = parsingException => invalid string-double
     *
     *  result: at java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1914) ...
     */
    @Test
    @DisplayName("should convert a number-dot-number-dot-number to a double")
    void testNumberDotNumberDotNumber() {
        Calculator calculator = new Calculator();

        calculator.pressDigitKey(5);
        calculator.pressDotKey();
        calculator.pressDigitKey(5);
        calculator.pressDotKey();
        calculator.pressDigitKey(5);

        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(0);
        calculator.pressDotKey();
        calculator.pressDigitKey(5);
        calculator.pressDigitKey(5);
        calculator.pressEqualsKey();

        String expected = "6.1";
        String actual = calculator.readScreen();

        assertEquals(expected, actual);
    }

    /** T3)
     *      Schreiben Sie zwei Bugfixes
     *      (also Änderungen der Implementierungsklasse Calculator),
     *      so dass die zwei zuvor hinzugefügten Tests erfolgreich durchlaufen.
     *      Falls Sie dabei das Verhalten so erweitern,
     *      dass es über das im JavaDoc spezifizierte hinausgeht
     *      (aber zum Verhalten des Online Calculator passt),
     *      dann erweitern Sie bitte auch das JavaDoc entsprechend.
     * */

    // see in the Calculator:

    /**   1)
     *      why: pressBinaryOperationKey =>
     *              parsed the screen to a double =>
     *                  you need the last value
     *
     *     public void pressClearKey() {
     *         screen = String.valueOf(latestValue);
     *         // screen = "0";
     *         // latestOperation = "";
     *         // latestValue = 0.0;
     *     }
     */

    /**    2)
     *      why: just catched the last char
     *              but when the user types in two dots, seperated with a nummeric value, the calculator goes down
     *              5.5.5 can't be converted to a double (or a other numeric-type)
     *
     *     public void pressDotKey() {
     *         //if(!screen.endsWith(".")) screen = screen + ".";
     *         if(!screen.contains(".")) screen = screen + ".";
     *     }
     */
}

