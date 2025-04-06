# ☕ RecipeBook JUnit Testing Project

This project is a **Java JUnit testing suite** designed to validate the functionality of a simple `RecipeBook` management system. It ensures that operations such as **adding, editing, deleting recipes**, and handling **invalid input** work as expected.

---

## ✅ Tested Features

| Feature                              | Description                                                              |
|--------------------------------------|--------------------------------------------------------------------------|
| Add valid recipe                     | Ensures recipes with valid inputs can be added to the recipe book        |
| Prevent duplicates                   | Avoids adding recipes with the same name more than once                  |
| Delete recipe                        | Deletes a recipe by index and returns its name                           |
| Edit recipe                          | Replaces a recipe at a given index and returns the original name         |
| Handle invalid input (negative)      | Throws exceptions for negative quantity and price values                 |
| Handle invalid input (non-numeric)   | Throws exceptions for non-numeric values in input fields                 |
| Valid getter methods                 | Ensures that all getter methods return correct values                    |
| Equals & hashCode                    | Validates `equals` and `hashCode` implementation for recipes             |
| Multiple assertions                  | Tests multiple recipes in a single test case                             |
| Timeout test                         | Ensures method execution completes within a time limit                   |

---

## 🧪 Test Tools Used

- **JUnit 5 (Jupiter)**
- **Parameterized Tests** (`@ValueSource`, `@CsvSource`)
- **Assertions** (`assertTrue`, `assertFalse`, `assertEquals`, `assertThrows`, `assertAll`, `assertNull`, `assertNotNull`)
- **Annotations** (`@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`, `@DisplayName`, `@Timeout`)

---

## 🏁 How to Run Tests

1. Make sure you have JDK and Maven or Gradle configured.
2. Import the project into an IDE like **IntelliJ** or **Eclipse**.
3. Run the `RecipeBookTest` class as a **JUnit Test**.
4. View the output in the console for pass/fail logs and debug messages.


---

## 📌 Notes

- Make sure to handle `RecipeException` whenever working with recipe values.
- The recipe book supports a **fixed number** of recipes; adding beyond the limit will return false.
- This project follows **Test-Driven Development (TDD)** principles.

---
