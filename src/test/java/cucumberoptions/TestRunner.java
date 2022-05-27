package cucumberoptions;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="resources/features",
		glue="stepdefinition"
	
		)
@Listeners({ExtentITestListenerClassAdapter.class})
public class TestRunner extends AbstractTestNGCucumberTests 
{

	
}