# Calculator Test Suite

This project provides a comprehensive test suite for the `Calculator` class, using **JUnit 5**. The tests validate the correctness and robustness of calculator operations such as addition, division, and factorial computation.


## ✅ Tested Features

### 1. `add(int... numbers)`
- **Valid Input**: Multiple integers, single integer, and no input.
- **Multiple Assertions**: Used in `testAddAndDivide`.

### 2. `divide(int a, int b)`
- **Valid Division**: Ensures correct result for valid division.
- **Invalid Division**: Checks for `ArithmeticException` on division by zero.
- **Multiple Assertions**: Checked with other methods in combined tests.

### 3. `factorial(int n)`
- **Valid Input**: Factorials of 0, 1, and 5.
- **Invalid Input**: Negative numbers should throw `IllegalArgumentException`.
- **Timeout Test**: Ensures computation completes within 5 seconds for large inputs like 1000.

## 🧪 Test Annotations Used

| Annotation         | Purpose                                                     |
|--------------------|-------------------------------------------------------------|
| `@Test`            | Marks a test method                                         |
| `@BeforeAll`       | Runs once before all tests                                  |
| `@AfterAll`        | Runs once after all tests                                   |
| `@BeforeEach`      | Initializes test state before each test                     |
| `@AfterEach`       | Cleans up test state after each test                        |
| `@Order(n)`        | Specifies execution order of test methods                   |
| `@DisplayName`     | Provides readable test names in reports                     |
| `@Disabled`        | Skips a failing test intentionally                          |
| `@ParameterizedTest` | Allows testing multiple inputs via `@CsvSource`           |
| `@Timeout`         | Fails the test if it exceeds the specified duration         |

## 🚫 Disabled or Failing Tests

- `testIntentionallyFailing()` is **disabled** and demonstrates a failure case (`2 + 2 = 5`).
- `testFailingTest()` checks proper exception handling for division by zero.

## ⏱️ Performance

- `testFactorialTimeout()` checks that the factorial function completes within **5 seconds** for large inputs.

## 📦 Dependencies

Ensure your `pom.xml` (for Maven) or `build.gradle` (for Gradle) includes:

```xml
<!-- JUnit 5 -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
