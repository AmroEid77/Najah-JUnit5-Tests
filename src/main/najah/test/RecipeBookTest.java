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
    
    // Test getter methods for all attributes
    @Test
    @DisplayName("Test Getter Methods for Recipe Attributes")
    void testGetters() throws RecipeException {
        System.out.println("Running tests for the testGetters() method");

        recipe1.setName("Latte");
        recipe1.setAmtCoffee("3");
        recipe1.setAmtMilk("2");
        recipe1.setAmtSugar("1");
        recipe1.setAmtChocolate("1");
        recipe1.setPrice("40");

        assertEquals("Latte", recipe1.getName());
        assertEquals(3, recipe1.getAmtCoffee());
        assertEquals(2, recipe1.getAmtMilk());
        assertEquals(1, recipe1.getAmtSugar());
        assertEquals(1, recipe1.getAmtChocolate());
        assertEquals(40, recipe1.getPrice());

        System.out.println("End of testGetters() method");
    }

    // Test equals method
    @Test
    @DisplayName("Test Equals Method for Recipe Objects")
    void testEqualsMethod() throws RecipeException {
        System.out.println("Running tests for the testEqualsMethod()");

        RecipeBook amroBook = new RecipeBook();

        recipe1.setName("Espresso");
        recipe2.setName("Espresso");

        assertTrue(recipe1.equals(recipe2), "Recipes with the same name should be equal");

        assertTrue(recipe1.equals(recipe1), "Same object should be the same");

        assertFalse(recipe1.equals(amroBook), "Different class should not be equal");

        recipe2.setName("Cappuccino");
        assertFalse(recipe1.equals(recipe2), "Recipes with different names should not be equal");

        System.out.println("End of testEqualsMethod() method");
    }

    // Test hashCode method
    @Test
    @DisplayName("Test HashCode Method for Recipe Objects")
    void testHashCode() throws RecipeException {
        System.out.println("Running tests for the testHashCode() method");

        recipe1.setName("Cappuccino");
        recipe2.setName("Cappuccino");

        assertEquals(recipe1.hashCode(), recipe2.hashCode(), "Recipes with the same name should have the same hashCode");

        System.out.println("End of testHashCode() method");
    }
    
    // Test setter method with valid values
    @Test
    @DisplayName("Test Setting Valid Values for Recipe Quantities")
    void testValidSetters() throws RecipeException {
        System.out.println("Running tests for the testValidSetters() method");

        recipe1.setAmtCoffee("5");
        recipe1.setAmtMilk("3");
        recipe1.setAmtSugar("2");
        recipe1.setAmtChocolate("1");
        recipe1.setPrice("30");

        assertEquals(5, recipe1.getAmtCoffee());
        assertEquals(3, recipe1.getAmtMilk());
        assertEquals(2, recipe1.getAmtSugar());
        assertEquals(1, recipe1.getAmtChocolate());
        assertEquals(30, recipe1.getPrice());

        System.out.println("End of testValidSetters() method");
    }

    // Test delete existing recipe
    @Test
    @DisplayName("Delete Existing Recipe")
    void testDeleteExistingRecipe() throws RecipeException {
        System.out.println("Running tests for the testDeleteExistingRecipe() method");

        recipe1.setName("Cappuccino");
        book.addRecipe(recipe1);

        String deleted = book.deleteRecipe(0);

        assertEquals("Cappuccino", deleted);
        assertEquals("", book.getRecipes()[0].getName(), "Deleted recipe should be reset");

        System.out.println("End of testDeleteExistingRecipe() method");
    }
    
    // Test delete invalid recipe index
    @Test
    @DisplayName("Delete Non-Existing Recipe Should Return Null")
    void testDeleteInvalidIndex() {
        System.out.println("Running tests for the testDeleteInvalidIndex() method");

        String deleted = book.deleteRecipe(1);
        assertNull(deleted, "Should return null for non-existent recipe");

        System.out.println("End of testDeleteInvalidIndex() method");
    }

    // Test edit existing recipe
    @Test
    @DisplayName("Edit Existing Recipe")
    void testEditExistingRecipe() throws RecipeException {
        System.out.println("Running tests for the testEditExistingRecipe() method");

        recipe1.setName("Cappuccino");
        book.addRecipe(recipe1);

        Recipe newRecipe = new Recipe();
        newRecipe.setName("Latte");
        String result = book.editRecipe(0, newRecipe);

        assertEquals("Cappuccino", result);
        assertEquals("", book.getRecipes()[0].getName(), "New recipe should be updated correctly");

        System.out.println("End of testEditExistingRecipe() method");
    }
    
    // Test editing non-existing recipe
    @Test
    @DisplayName("Edit Non-Existing Recipe Should Return Null")
    void testEditNonExistingRecipe() throws RecipeException {
        System.out.println("Running tests for the testEditNonExistingRecipe() method");

        Recipe r = new Recipe();
        r.setName("DoesNotExist");
        String result = book.editRecipe(1, r);
        assertNull(result);

        System.out.println("End of testEditNonExistingRecipe() method");
    }

}
