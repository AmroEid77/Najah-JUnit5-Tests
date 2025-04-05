package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.Calculator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    // Parameterized test for factorial with CSV input including negative values
    @ParameterizedTest
    @CsvSource({
        "0, 1",       // Factorial of 0 is 1
        "1, 1",       // Factorial of 1 is 1
        "5, 120",     // Factorial of 5 is 120
        "-1, -1"      // Factorial of -1 is invalid (expected to throw exception or return -1)
    })

    @Order(4)
    @DisplayName("Test Factorial Method with parameterized values including negative")
    public void testFactorial(int input, int expected) {
        System.out.println("Running tests for the factorial() method with input: " + input);

        if (input >= 0) {
            // Test expected factorial result for non-negative inputs
            assertEquals(expected, calc.factorial(input), "Factorial of " + input + " should equal " + expected);
        } else {
            // Test for negative values, expecting an exception or a specific value like -1
            assertThrows(IllegalArgumentException.class, () -> calc.factorial(input), "Factorial of negative number should throw an exception");
        }

    }
    
 // Timeout test for factorial method (testing a large value)
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @Order(5)
    @DisplayName("Test Factorial Method with timeout")
    public void testFactorialTimeout() {
    	System.out.println("Running tests for the factorial() method with valid input and Timeout 5 seconds");
        assertTimeout(Duration.ofSeconds(5), () -> calc.factorial(1000), "Factorial of 1000 should finish within 5 seconds");
    }

    // Failing test (intentionally disabled)
    @Test
    @Disabled("This test is intentionally failing, expecting incorrect behavior")
    @Order(6)
    @DisplayName("Intentionally failing test")
    // This test fails intentionally because it expects 2 + 2 = 5 (which is incorrect).
    // To fix: change expected value from 5 to 4 and remove @Disabled.
    public void testIntentionallyFailing() {
    	System.out.println("Running tests for the add() method with invalid expected output and disabled");
        assertEquals(5, calc.add(2, 2), "Incorrect expectation: 2 + 2 should equal 4, but we expect 5");
    }
    
    // Failing test
    @Test
    @Order(7)
    @DisplayName("Test Divide Method with invalid input (division by zero)")
    public void testFailingTest() {
    	System.out.println("Running tests for the divide() method with invalid input");
        assertThrows(ArithmeticException.class, () -> calc.divide(1, 0), "Dividing by zero should throw ArithmeticException");
    }

    // Multiple assertions in a single test
    @Test
    @Order(8)
    @DisplayName("Test Add and Divide Method with multiple assertions")
    public void testAddAndDivide() {
    	System.out.println("Running tests for the divide() and add() methods with valid input");
        assertEquals(10, calc.add(5, 5), "Adding 5 + 5 should equal 10");
        assertEquals(0, calc.add(0, 0), "Adding 0 + 0 should equal 0");
        assertEquals(2, calc.divide(6, 3), "6 divided by 3 should equal 2");
        assertEquals(1, calc.divide(3, 3), "3 divided by 3 should equal 1");

    }
    
}
