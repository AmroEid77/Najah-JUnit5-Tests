# 📦 Product Testing with JUnit

This project contains unit tests for the `Product` class using **JUnit 5**. It checks product creation, discount logic, price calculations, and exception handling with various test strategies.


---

## ✅ What’s Being Tested?

### 1. **Product Creation**
- Product should initialize with name, price, and default discount.
- ❌ Negative price should throw an exception.

### 2. **Valid Discounts**
- Products correctly apply valid discount values (0–50%).
- Final price should reflect the applied discount.

### 3. **Invalid Discounts**
- ❌ Applying discount <0% or >50% throws an `IllegalArgumentException`.

### 4. **Performance Test**
- Discount application and price calculation should complete within **10 ms**.

### 5. **Multiple Assertions**
- Use of `assertAll` to validate name, price, and discount together.

### 6. **Parameterized Testing**
- Check different invalid discount values using `@ValueSource`.

---

## 🔬 Test Annotations Used

| Annotation            | Description |
|-----------------------|-------------|
| `@BeforeAll`          | Runs once before all tests (setup) |
| `@AfterAll`           | Runs once after all tests (cleanup) |
| `@BeforeEach`         | Runs before each test (initialize products) |
| `@AfterEach`          | Runs after each test |
| `@Test`               | Declares a test method |
| `@DisplayName`        | Custom name for test case |
| `@ParameterizedTest`  | Runs the same test with multiple inputs |
| `@ValueSource`        | Supplies values for `@ParameterizedTest` |
| `@Timeout`            | Fails test if it exceeds time limit |
| `assertThrows`        | Asserts an exception is thrown |
| `assertAll`           | Groups multiple assertions |

---

## 🧪 Sample Products Used in Tests

| Product Name              | Price (USD) |
|---------------------------|-------------|
| MacBook Pro               | 2000        |
| Samsung Galaxy S23        | 900         |
| Beyerdynamic DT 700 PRO X | 350         |
| iPhone 16 Pro Max         | 1600        |
| HyperX Cloud 2            | 100         |
| AirPods Pro               | 250         |

---




