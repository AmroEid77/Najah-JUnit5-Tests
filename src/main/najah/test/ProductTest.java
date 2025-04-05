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

}
