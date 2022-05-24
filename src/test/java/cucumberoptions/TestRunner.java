package cucumberoptions;
//import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue="stepdefinition")

public class TestRunner extends AbstractTestNGCucumberTests 
{

}
