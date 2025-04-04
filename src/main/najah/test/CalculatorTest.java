package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

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

}
