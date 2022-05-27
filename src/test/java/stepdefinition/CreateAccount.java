package stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import com.genpact.miniproject.CucumberProject.Base;
import com.genpact.miniproject.CucumberProject.HomePageObjects;
import com.genpact.miniproject.CucumberProject.LoginPageObjects;
import com.genpact.miniproject.CucumberProject.NewAccountObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateAccount extends Base {
	
	public CreateAccount() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	HomePageObjects hpo=new HomePageObjects(driver);
	NewAccountObjects nao=new NewAccountObjects(driver);
	LoginPageObjects lpo1=new LoginPageObjects(driver);
	
	
	
	
	private static Logger log=LogManager.getLogger(CreateAccount.class.getName());
	

	//Create new account scenario, contains both savings and checking
		@Given("^User launches portal with \"([^\"]*)\" and \"([^\"]*)\"$")
		public void launch(String username,String password) throws IOException, InterruptedException
		{
			
			lpo1.getUsername().sendKeys(username);
			lpo1.getPassword().sendKeys(password);
			lpo1.getLogin().click();
			log.info("User logged in");
		}
		@When("^User clicks on Open New Account with (.+) and (.+)$")
		public void openNewAccount(String type,String index) throws InterruptedException
		{
			
			hpo.getOpenNewAccount().click();
			Thread.sleep(1000);
			nao.setAccountType(type);
			Thread.sleep(1000);
			nao.setAccountId(Integer.valueOf(index));
			Thread.sleep(1000);
			nao.getOpenNewAccount().click();
			log.info("A new account is created");
		}
		@Then("^Verify a new account is created$")
		public void verifyAccountCreated() throws InterruptedException
		{

			Assert.assertEquals(nao.accountGetText(),"Account Opened!");
			driver.close();

		}


}
