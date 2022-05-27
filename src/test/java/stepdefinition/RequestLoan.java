package stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.genpact.miniproject.CucumberProject.Base;
import com.genpact.miniproject.CucumberProject.HomePageObjects;
import com.genpact.miniproject.CucumberProject.RequestLoanObjects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestLoan {
	//Scenario to request loan
	HomePageObjects hpo=new HomePageObjects(Base.getDriver());
	RequestLoanObjects rlo=new RequestLoanObjects(Base.getDriver());
	private static Logger log=LogManager.getLogger(RequestLoan.class.getName());
@When("User requests loan amount of {string} with downpayment {string}")
public void user_requests_loan_amount_of_with_downpayment(String amount, String downPayment) throws InterruptedException {
	
	hpo.getRequestLoan().click();
	Thread.sleep(1000);
	
	rlo.getAmount().sendKeys(amount);
	rlo.getDownPayment().sendKeys(downPayment);
	Thread.sleep(1000);
	rlo.getApplyNow().click();
	Thread.sleep(1000);
	
	log.info("Requesting loan");
}
@Then("Verify that user is able to request loan")
public void verify_that_user_is_able_to_request_loan() {
	Assert.assertEquals(rlo.getLoanRequestProcessed(),"Loan Request Processed");
	Base.tearDown();

}
}