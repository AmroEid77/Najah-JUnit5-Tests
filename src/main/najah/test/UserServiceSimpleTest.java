package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import main.najah.code.UserService;

@DisplayName("User Services Tests")
@Execution(ExecutionMode.CONCURRENT)
class UserServiceSimpleTest {

	 UserService user;

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
	        user = new UserService();
	        System.out.println("Setting up user object before test execution");
	    }

	    @AfterEach
	    public void endTestStep() {
	        System.out.println("Cleaning up after test execution");
	    }
	    
	    
	    // Test Valid Email
	    @Test
	    @DisplayName("Test Valid Email Format")
	    public void testValidEmail() {
	        System.out.println("Testing valid email format");
	        assertTrue(user.isValidEmail("amro.eidd@gmail.com"), "Email should be valid");
	        System.out.println("Test passed: Valid email format");
	    }

	    // Test Invalid Email (Missing @)
	    @Test
	    @DisplayName("Test Invalid Email Format (Missing @)")
	    public void testInvalidEmailMissingAt() {
	        System.out.println("Testing invalid email format (missing @)");
	        assertFalse(user.isValidEmail("amroeiddgmail.com"), "Email should be invalid");
	        System.out.println("Test passed: Invalid email format (missing @)");
	    }
	    
	    // Test Empty Email
	    @Test
	    @DisplayName("Test Invalid Email Format (Empty Email)")
	    public void testInvalidEmailEmpty() {
	        System.out.println("Testing empty email format");
	        assertFalse(user.isValidEmail(""), "Email should be invalid");
	        System.out.println("Test passed: Empty email is invalid");
	    }

	    // Test Invalid Authentication (Incorrect credentials)
	    @Test
	    @DisplayName("Test Invalid Username and Password (Incorrect credentials)")
	    public void testInvalidAuthentication() {
	        System.out.println("Testing invalid username and password");
	        assertFalse(user.authenticate("amro", "wrongpassword"), "Authentication should fail with incorrect credentials");
	        System.out.println("Test passed: Authentication failed for incorrect credentials");
	    }

	    // Test Valid Authentication (Correct credentials)
	    @Test
	    @DisplayName("Test Valid Username and Password (Correct credentials)")
	    public void testValidAuthentication() {
	        System.out.println("Testing valid username and password");
	        assertTrue(user.authenticate("admin", "1234"), "Authentication should succeed with correct credentials");
	        System.out.println("Test passed: Authentication succeeded for correct credentials");
	    }

}
