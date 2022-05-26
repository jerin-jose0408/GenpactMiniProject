package cucumberoptions;

//import org.junit.runner.RunWith;
import io.cucumber.testng.CucumberOptions;


import org.testng.annotations.Listeners;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		//tags="@parabank",
		glue="stepdefinition"
		//plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//monochrome = true,
		//publish=true
		)
@Listeners({ExtentITestListenerClassAdapter.class})
public class TestRunner extends AbstractTestNGCucumberTests 
{

	
}