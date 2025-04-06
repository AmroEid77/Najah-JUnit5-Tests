## 📦 Test Suite

This is a **JUnit Test Suite** that groups multiple test classes together for execution. It can be used to run tests from different classes or packages as a unit.

---

### 🧳 `TestSuite.java`

```java
package main.najah.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
// For classes
//@SelectClasses({CalculatorTest.class, ProductTest.class, RecipeBookTest.class, UserServiceSimpleTest.class})

// For packages (not practical)
@SelectPackages("main.najah.test")
public class TestSuite {

}
