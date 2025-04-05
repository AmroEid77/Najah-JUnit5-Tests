package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.najah.code.Product;

@DisplayName("Prodcut Tests")
public class ProductTest {
	Product laptop;
    Product smartphone;
    Product headphones;
    Product iphone;
    Product hyperXCloud;
    Product airpods;

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
        // Initialize products with new prices
        laptop = new Product("MacBook Pro", 2000);
        smartphone = new Product("Samsung Galaxy S23", 900);
        headphones = new Product("Beyerdynamic DT 700 PRO X", 350);
        iphone = new Product("iPhone 16 Pro Max", 1600);
        hyperXCloud = new Product("HyperX Cloud 2", 100);
        airpods = new Product("AirPods Pro", 250);
        System.out.println("Setting up Product objects before test execution");
    }

    @AfterEach
    public void endTestStep() {
        System.out.println("Cleaning up after test execution");
    }
    
    @Test
    @DisplayName("Test Product Creation with Negative Price Should Throw Exception")
    public void testNegativePrice() {
        System.out.println("Running tests for creating product with negative price");

        double invalidPrice = -100;

        // Check that the exception message matches
        assertThrows(IllegalArgumentException.class ,() ->{new Product("Test Product", invalidPrice);});
        System.out.println("Test passed: Exception thrown for negative price");
    }

    // Test valid product initialization
    @Test
    @DisplayName("Test Valid Product Initialization with Correct Values")
    public void testValidProductCreation() {
        System.out.println("Running tests for valid product initialization");

        assertEquals("MacBook Pro", laptop.getName(), "Product name should be MacBook Pro");
        System.out.println("Checked product name for MacBook Pro");

        assertEquals(2000, laptop.getPrice(), 0.01, "Price for MacBook Pro should be 2000");
        System.out.println("Checked price for MacBook Pro");

        assertEquals(0, laptop.getDiscount(), 0.01, "Discount for MacBook Pro should be 0");
        System.out.println("Checked discount for MacBook Pro");

        assertEquals("Samsung Galaxy S23", smartphone.getName(), "Product name should be Samsung Galaxy S23");
        System.out.println("Checked product name for Samsung Galaxy S23");

        assertEquals(900, smartphone.getPrice(), 0.01, "Price for Samsung Galaxy S23 should be 900");
        System.out.println("Checked price for Samsung Galaxy S23");

        assertEquals("iPhone 16 Pro Max", iphone.getName(), "Product name should be iPhone 16 Pro Max");
        System.out.println("Checked product name for iPhone 16 Pro Max");

        assertEquals(1600, iphone.getPrice(), 0.01, "Price for iPhone 16 Pro Max should be 1600");
        System.out.println("Checked price for iPhone 16 Pro Max");

        assertEquals("AirPods Pro", airpods.getName(), "Product name should be AirPods Pro");
        System.out.println("Checked product name for AirPods Pro");

        assertEquals(250, airpods.getPrice(), 0.01, "Price for AirPods Pro should be 250");
        System.out.println("Checked price for AirPods Pro");
    }

}
