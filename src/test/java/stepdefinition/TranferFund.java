package stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.genpact.miniproject.CucumberProject.Base;
import com.genpact.miniproject.CucumberProject.HomePageObjects;
import com.genpact.miniproject.CucumberProject.TransferFundObjects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TranferFund {

	private static Logger log=LogManager.getLogger(Login.class.getName());	
	HomePageObjects hpo=new HomePageObjects(Base.getDriver());
	TransferFundObjects tao=new TransferFundObjects(Base.getDriver());
	
	//Transfer funds scenario
	@When("^User transfers fund of (.+) from (.+) to (.+)$")
	public void transferFund(String amount,String from,String to) throws InterruptedException
	{
		hpo.getTransferFunds().click();
		Thread.sleep(3000);
		
		tao.getAmount().sendKeys(amount);;
		Thread.sleep(1000);
		tao.setfromAccount(from);
		Thread.sleep(1000);
		tao.setToAccount(to);
		Thread.sleep(1000);
		tao.getTransfer().click();
		Thread.sleep(1000);
		log.info("Transferrring funds");
	}
	@Then("^Verify transfer is successful$")
	public void verifyFundsTransfered() throws InterruptedException
	{

		Assert.assertEquals(tao.getTranferComplete(),"Transfer Complete!");
		Base.tearDown();

	}

}
