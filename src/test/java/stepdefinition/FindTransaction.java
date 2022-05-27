package stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.genpact.miniproject.CucumberProject.Base;
import com.genpact.miniproject.CucumberProject.FindTransactionObjects;
import com.genpact.miniproject.CucumberProject.HomePageObjects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindTransaction {
	private static Logger log=LogManager.getLogger(FindTransaction.class.getName());
	HomePageObjects hpo=new HomePageObjects(Base.getDriver());
	FindTransactionObjects fto=new FindTransactionObjects(Base.getDriver());
	//Find transaction by amount scenario
		@When("User provides the amount as {string} and clicks on Find")
		public void user_provides_the_amount_as_and_clicks_on_find(String string) throws InterruptedException {
			
			hpo.getFindTransactions().click();
			Thread.sleep(1000);
			fto.getAmount().sendKeys(string);
			Thread.sleep(500);
			fto.getTransaction().click();
			Thread.sleep(1000);
			log.info("Finding transaction by amount");
		}
		@Then("Verify find transaction is successful")
		public void verify_find_transaction_is_successful() {
			Assert.assertEquals(fto.getTransactionReult(),"Transaction Results");
			Base.tearDown();
		}


}
