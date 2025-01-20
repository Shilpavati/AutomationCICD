package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*
 * @CucumberOptions(features = "src/test/java/cucumber", glue =
 * "stepDefinitions", monochrome = true, plugin = { "html:taget/cucumber.html"
 * }) public class TestNGTestRunner extends AbstractTestNGCucumberTests {
 * 
 * }
 */

@CucumberOptions(features = "src/test/java/cucumber", glue = "stepDefinitions", tags = "@Regression", monochrome = true, plugin = {
		"html:target/cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}