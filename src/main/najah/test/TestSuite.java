package main.najah.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//For classes
//@SelectClasses({CalculatorTest.class, ProductTest.class, RecipeBookTest.class, UserServiceSimpleTest.class})

//For packages (not practical))
@SelectPackages("main.najah.test")

class TestSuite {


}
