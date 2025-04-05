package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    
 // Test applying a valid discount
    @Test
    @DisplayName("Test Apply Valid Discount to Products")
    public void testApplyValidDiscount() {
        System.out.println("Running tests for applying valid discounts");

        laptop.applyDiscount(20);
        assertEquals(1600, laptop.getFinalPrice(), 0.01, "Laptop final price should be 1600 after 20% discount");
        System.out.println("Applied 20% discount to MacBook Pro and checked final price");

        smartphone.applyDiscount(10);
        assertEquals(810, smartphone.getFinalPrice(), 0.01, "Smartphone final price should be 810 after 10% discount");
        System.out.println("Applied 10% discount to Samsung Galaxy S23 and checked final price");
    }

    // Test applying an invalid discount
    @ParameterizedTest
    @ValueSource(doubles = {-5, 60, 1000, -100})
    @DisplayName("Test Apply Invalid Discount Should Throw Exception")
    public void testInvalidDiscount(double invalidDiscount) {
        System.out.println("Running tests for applying invalid discount: " + invalidDiscount);

        assertThrows(IllegalArgumentException.class, () -> laptop.applyDiscount(invalidDiscount),
            "Discount value should be between 0 and 50");
        System.out.println("Checked invalid discount " + invalidDiscount + " for MacBook Pro");
    }

    // Test timeout for price calculation
    @Test
    @DisplayName("Test Final Price Calculation for Expensive Product with Timeout")
    @Timeout(value = 10, unit=TimeUnit.MILLISECONDS)
    public void testFinalPriceCalculationWithinTime() {
        System.out.println("Running tests for final price calculation within timeout");

            iphone.applyDiscount(5);
            double finalPrice = iphone.getFinalPrice();
            assertEquals(1520, finalPrice, 0.01, "Final price should be 1520 after 5% discount");
            System.out.println("Applied 5% discount to iPhone 16 Pro Max and checked final price");
    }

}
