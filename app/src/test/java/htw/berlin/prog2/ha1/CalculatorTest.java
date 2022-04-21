package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.management.loading.MLet;

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

    //1. grüner test
    @Test
    @DisplayName("should display result after split two positive multi-digit numbers")
    void testAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(4);

        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // 1.roter Test

    @Test
    @DisplayName("should display result after subtract two postive multi-digit-numbers")
    void testsubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressDigitKey(8);

        calc.pressEqualsKey();

        String expected = "36";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

      @@public void pressBinaryOperationKey() {

          if(screen.endWith("+") screen= "-")
//2.roter test
      @Test
      @DisplayName("should display ´0´ result after multiply by zero")
      void testmultiplication() (
              Calculator calc= new Calculator()
            calc.pressDigitKey(2);
            calc.pressDigitKey(1);
            calc.pressBinaryOperationKey("*");
            calc.pressDigitKey(0);
            calc.pressDigitKey();

            calc.pressEqualsKey();

            String expected = "22";
            String actual = calc.readScreen();

            assertEquals(expected, actual);


                    )




        }

}

