# ✅ UserServiceSimpleTest

## 🧪 Test Class: `UserServiceSimpleTest`

This test class is designed to **validate the core functionalities** of the `UserService` class. It focuses on:

- 📧 Email validation
- 🔐 User authentication
- ⏱️ Timeout constraints
- ✅ Parameterized testing
- 🔄 Concurrent execution


---

## ⚙️ Used JUnit Features

| Feature             | Description                                          |
|---------------------|------------------------------------------------------|
| `@Test`             | Standard unit tests                                  |
| `@DisplayName`      | Custom names for each test                           |
| `@BeforeAll`        | Setup before all tests                               |
| `@AfterAll`         | Cleanup after all tests                              |
| `@BeforeEach`       | Setup before each test                               |
| `@AfterEach`        | Cleanup after each test                              |
| `@Timeout`          | Ensures a test completes within a time limit         |
| `@Execution(CONCURRENT)` | Executes tests in parallel                      |
| `@ParameterizedTest`| Allows running the same test with different inputs   |
| `@CsvSource`        | Provides test data for parameterized test            |
| `assertAll`         | Group assertions                                     |
| `assertTrue`, `assertFalse`, `assertEquals` | Core assertions             |

---

## 🔍 Test Cases Overview

| Test Method                    | Description                                                    |
|--------------------------------|----------------------------------------------------------------|
| `testValidEmail()`             | Checks valid email format                                      |
| `testInvalidEmailMissingAt()` | Fails when email is missing `@`                                |
| `testInvalidEmailEmpty()`      | Fails on empty email                                           |
| `testInvalidAuthentication()`  | Fails login with incorrect credentials                        |
| `testValidAuthentication()`    | Passes login with valid credentials                           |
| `testMultipleEmailInputs()`    | Parameterized: tests both valid & invalid emails              |
| `testAuthenticationTimeout()`  | Ensures login completes within timeout                        |
| `testMultipleAssertions()`     | Checks email + authentication in one test                     |
| `testLongLocalPartEmail()`     | Validates email with long local part                          |

---

## ✅ Example Assertions

```java
assertTrue(user.isValidEmail("amro.eidd@gmail.com"));
assertFalse(user.authenticate("amro", "wrongpassword"));
assertAll(
    () -> assertTrue(user.authenticate("admin", "1234")),
    () -> assertFalse(user.isValidEmail("invalidemail"))
);
```
---

## 🧼 Lifecycle Logging

Each test prints steps for:

- 🔧 **Setup** (`@BeforeEach`)
- ▶️ **Execution**
- 🧹 **Cleanup** (`@AfterEach`)

This helps with **debugging** and **tracking test flow**.

---

## 📌 Notes

- All tests are run **concurrently** for speed using:

  ```java
  @Execution(ExecutionMode.CONCURRENT)
  ```
Parameterized tests improve coverage and reduce redundancy by testing multiple inputs in a single test method.
