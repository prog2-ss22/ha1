package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.Assertions;
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

  @Test
  @DisplayName("should display result after multiplying two positive multi-digit numbers")
  void testPositiveMultiplication() {
    Calculator calculator = new Calculator();
    calculator.pressDigitKey(8);
    calculator.pressDigitKey(1);
    calculator.pressBinaryOperationKey("x");
    calculator.pressDigitKey(2);
    calculator.pressDigitKey(2);
    calculator.pressEqualsKey();
    String expected = "1782";
    String actual = calculator.readScreen();
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("should display result after multiplication of two negative numbers")
  void testNegativeMultiplication() {
    Calculator calculator = new Calculator();
    calculator.pressDigitKey(8);
    calculator.pressNegativeKey();
    calculator.pressBinaryOperationKey("x");
    calculator.pressDigitKey(7);
    calculator.pressEqualsKey();
    String expected = "-56";
    String actual = calculator.readScreen();

    assertEquals(expected, actual);

  }

  @Test
  @DisplayName("should display result after division of a positive four digits number")
  void testPositiveDivision() {
    Calculator calculator = new Calculator();
    calculator.pressDigitKey(9);
    calculator.pressDigitKey(7);
    calculator.pressDigitKey(5);
    calculator.pressDigitKey(3);
    calculator.pressBinaryOperationKey("/");
    calculator.pressDigitKey(3);
    calculator.pressEqualsKey();
    String expected = "3251";
    String actual = calculator.readScreen();

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("should display result after addition of two decimal numbers")
  void testAdditionDecimalNumbers() {
    Calculator calculator = new Calculator();
    calculator.pressDigitKey(1);
    calculator.pressDotKey();
    calculator.pressDigitKey(6);
    calculator.pressBinaryOperationKey("+");
    calculator.pressDigitKey(1);
    calculator.pressDotKey();
    calculator.pressDigitKey(7);
    calculator.pressEqualsKey();
    String expected = "3.3";
    String actual = calculator.readScreen();
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("should display correct result for addition after pressing clear two times")
  void testClearAndCheckResult() {
    Calculator calculator = new Calculator();
    calculator.pressDigitKey(5);
    calculator.pressBinaryOperationKey("+");
    calculator.pressDigitKey(5);
    calculator.pressClearKey();
    calculator.pressDigitKey(7);
    calculator.pressEqualsKey();
    String expected = "12";
    String actual = calculator.readScreen();
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("should display correct result after executing multiple operations in a row")
  void testMultipleOperations() {
    Calculator calculator = new Calculator();
    calculator.pressDigitKey(2);
    calculator.pressBinaryOperationKey("x");
    calculator.pressDigitKey(3);
    calculator.pressBinaryOperationKey("-");
    calculator.pressDigitKey(5);
    calculator.pressBinaryOperationKey("+");
    String expected = "1";
    String actual = calculator.readScreen();
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Should return Error if dividing by 0")
  void testDivideByZero() throws Exception {
    Calculator calculator = new Calculator();
    IllegalArgumentException thrown = Assertions
        .assertThrows(IllegalArgumentException.class, () -> {
          calculator.pressDigitKey(4);
          calculator.pressBinaryOperationKey("x");
          calculator.pressDigitKey(3);
          calculator.pressBinaryOperationKey("/");
          calculator.pressDigitKey(0);
          calculator.pressBinaryOperationKey("+");
        }, "IllegalArgumentException was expected");
    String expected = "Error";
    String actual = calculator.readScreen();
    assertEquals(expected, actual);
    Assertions.assertEquals("Error", thrown.getMessage());
  }
}