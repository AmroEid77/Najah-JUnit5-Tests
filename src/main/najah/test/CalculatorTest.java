package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.Calculator;

@DisplayName("Calculator Tests")
public class CalculatorTest {
	
    Calculator calc;

    @BeforeAll
    public static void beforeClassStep() {
        System.out.println("Setting up test environment before executing tests");
    }

    @AfterAll
    public static void afterClassStep() {
        System.out.println("Cleaning up test environment after test execution");
    }

    @BeforeEach
    public void preTestStep() {
        calc = new Calculator();
        System.out.println("Setting up Calculator object before test execution");
    }

    @AfterEach
    public void endTestStep() {
        System.out.println("Cleaning up after test execution");
    }

    // Valid test for the 'add()' method
    @Test
    @Order(1)
    @DisplayName("Test Add Method with valid input")
    public void testAddValid() {
    	System.out.println("Running tests for the add() method with valid input");
    	
        assertEquals(63, calc.add(4, 10, 49), "Adding 4, 10, 49 should equal 63");
        assertEquals(5, calc.add(5), "Adding single number 5 should equal 5");
        assertEquals(0, calc.add(), "Adding no numbers should equal 0");
    }

    // Invalid test for 'divide()' (division by zero)
    @Test
    @Order(2)
    @DisplayName("Test Divide Method with invalid input (division by zero)")
    public void testDivideByZero() {
    	System.out.println("Running tests for the divide() method with invalid input");

        assertThrows(ArithmeticException.class, () -> calc.divide(1, 0), "Dividing by 0 should throw ArithmeticException");
    }

    // Valid test for 'divide()' method
    @Test
    @Order(3)
    @DisplayName("Test Divide Method with valid input")
    public void testDivideValid() {
    	System.out.println("Running tests for the divide() method with valid input");
        assertEquals(2, calc.divide(6, 3), "6 divided by 3 should equal 2");
    }

    // Parameterized test for factorial
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5})
    @DisplayName("Test Factorial Method with parameterized values")
    public void testFactorial(int input) {
    	System.out.println("Running tests for the factorial() method with valid input");

        if (input == 0) {
            assertEquals(1, calc.factorial(0), "Factorial of 0 should equal 1");
        } else if (input == 1) {
            assertEquals(1, calc.factorial(1), "Factorial of 1 should equal 1");
        } else if (input == 5) {
            assertEquals(120, calc.factorial(5), "Factorial of 5 should equal 120");
        }
    }
    
}
