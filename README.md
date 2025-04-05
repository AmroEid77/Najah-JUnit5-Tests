# JUnit 5 Test Suite for main.najah Project

This repository contains a comprehensive set of JUnit 5 tests for the classes in the `main.najah.code` package. The tests cover all major features and functionality, ensuring robust code coverage and validation.

## Project Structure

The tests are organized into individual classes for each class in the `main.najah.code` package. Each test class meets specific testing criteria to ensure high-quality code and full coverage.

### Classes Tested

- **Calculator**
- **Product**
- **UserService**
- **RecipeBook**

## Key Features of the Test Suite

### 1. **Test Classes for Each Class**
Each class has a corresponding test class:
- **CalculatorTest**
- **ProductTest**
- **UserServiceTest**
- **RecipeBookTest**

Each test class includes the following features:

- **Valid and Invalid Input Testing:** Each test method checks for both valid and invalid inputs to ensure the classes handle edge cases correctly.
- **@DisplayName Annotation:** Descriptive test names are used to make the purpose of each test clear.
- **Parameterized Tests:** Some tests are parameterized using `@ParameterizedTest` and `@ValueSource` or `@CsvSource` to cover multiple scenarios with a single method.
- **Timeout Tests:** Timeout tests ensure that the methods complete within an expected time limit.
- **Multiple Assertions:** Multiple assertions are used within a single test method to check different aspects of the code in one test.

### 2. **JUnit 5 Test Suite**
A JUnit 5 test suite was created using the `@Suite` annotation to group and run all test classes together. The suite is configured to run all tests from the `main.najah.test` package.

### 3. **Ordered Test Execution**
The `CalculatorTest` class demonstrates ordered test execution using the `@Order` annotation, ensuring tests run in a specific order when necessary.

### 4. **Lifecycle Hooks**
Lifecycle hooks such as `@BeforeAll`, `@AfterAll`, `@BeforeEach`, and `@AfterEach` are used to manage setup and teardown actions before and after tests. Simple debug messages like "setup complete" are printed to provide insights into the test lifecycle.

### 5. **Disabled Tests**
An intentionally failing test has been added with the `@Disabled` annotation. A note on how to fix the failing test is included for future resolution.

### 6. **Test Coverage**
- **`main.najah.test` package:** **93.2%** coverage
- **`main.najah.code` package:** **97.9%** coverage

Test coverage for each individual class is **100%**:
- **Calculator**: 100% coverage
- **Product**: 100% coverage
- **UserService**: 100% coverage
- **RecipeBook**: 100% coverage

The tests ensure that all major aspects of the code are properly validated, including edge cases, valid inputs, and error handling.

### 7. **Parallel Test Execution**
Parallel execution is enabled in JUnit 5 for faster test execution. The `@Execution(ExecutionMode.CONCURRENT)` annotation is applied to one of the test classes to enable concurrent test execution.

## Running the Tests

To run the tests, use the following steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/Najah-JUnit5-Tests
2. Open the project in your favorite IDE that support Java or run the tests

3. Run the code :)
