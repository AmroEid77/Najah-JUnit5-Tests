package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.Recipe;
import main.najah.code.RecipeBook;
import main.najah.code.RecipeException;

@DisplayName("Recipe Book and Recipe Tests")
class RecipeBookTest {

    RecipeBook book;
    Recipe recipe1, recipe2;

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
        book = new RecipeBook();
        recipe1 = new Recipe();
        recipe2 = new Recipe();
        System.out.println("Setting up RecipeBook object before test execution");
    }

    @AfterEach
    public void endTestStep() {
        System.out.println("Cleaning up after test execution");
    }
    
 // Test valid recipe addition
    @Test
    @DisplayName("Add Valid Recipe Successfully")
    void testAddValidRecipe() throws RecipeException {
        System.out.println("Running tests for the testAddValidRecipe() method");
        
        recipe1.setName("Mocha");
        recipe1.setAmtCoffee("2");
        recipe1.setAmtMilk("1");
        recipe1.setAmtSugar("1");
        recipe1.setAmtChocolate("2");
        recipe1.setPrice("50");

        boolean result = book.addRecipe(recipe1);

        assertTrue(result, "Recipe should be added successfully");
        assertEquals("Mocha", book.getRecipes()[0].getName());

        System.out.println("End of testAddValidRecipe() method");
    }

    // Test invalid inputs (negative values) for setting quantities and price
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100"})
    void testInvalidRecipeQuantities(String invalidValue) {
        System.out.println("Running tests for the testInvalidRecipeQuantities() method with invalid input: " + invalidValue);
        
        assertThrows(RecipeException.class, () -> recipe1.setAmtCoffee(invalidValue));
        assertThrows(RecipeException.class, () -> recipe1.setAmtMilk(invalidValue));
        assertThrows(RecipeException.class, () -> recipe1.setAmtSugar(invalidValue));
        assertThrows(RecipeException.class, () -> recipe1.setAmtChocolate(invalidValue));
        assertThrows(RecipeException.class, () -> recipe1.setPrice(invalidValue));

        System.out.println("End of testInvalidRecipeQuantities() method");
    }

    // Test invalid input (non-numeric values) for setting quantities and price
    @Test
    @DisplayName("Test Non-Numeric Input for Recipe Quantities and Price")
    void testNonNumericRecipeInputs() {
        System.out.println("Running tests for the testNonNumericRecipeInputs() method");

        assertThrows(RecipeException.class, () -> recipe1.setAmtCoffee("abc"));
        assertThrows(RecipeException.class, () -> recipe1.setAmtMilk("abc"));
        assertThrows(RecipeException.class, () -> recipe1.setAmtSugar("abc"));
        assertThrows(RecipeException.class, () -> recipe1.setAmtChocolate("abc"));
        assertThrows(RecipeException.class, () -> recipe1.setPrice("abc"));

        System.out.println("End of testNonNumericRecipeInputs() method");
    }

}
