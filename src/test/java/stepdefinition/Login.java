package stepdefinition;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.genpact.miniproject.CucumberProject.Base;
import com.genpact.miniproject.CucumberProject.BillPayObjects;

import com.genpact.miniproject.CucumberProject.FindTransactionObjects;
import com.genpact.miniproject.CucumberProject.HomePageObjects;
import com.genpact.miniproject.CucumberProject.LoginPageObjects;
import com.genpact.miniproject.CucumberProject.NewAccountObjects;
import com.genpact.miniproject.CucumberProject.RequestLoanObjects;
import com.genpact.miniproject.CucumberProject.TransferFundObjects;
import com.genpact.miniproject.CucumberProject.UpdateContactInfoObjects;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.*;



public class Login extends Base{

	public Login() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	//WebDriver driver=Base.getDriver();
	private static Logger log=LogManager.getLogger(Login.class.getName());
	//Initialization of all the page objects
	LoginPageObjects lpo,lpo1;
	HomePageObjects hpo;
	NewAccountObjects nao;
	TransferFundObjects tao;
	BillPayObjects bpo;
	FindTransactionObjects fto;
	UpdateContactInfoObjects ucio;
	RequestLoanObjects rlo;
	
	//Login and logout scenario
	@Given("^User launches portal$")
	public void loginPage() throws IOException
	{
		lpo=new LoginPageObjects(driver);
	}
	
	@When("^User Logs into the application with \"([^\"]*)\" and \"([^\"]*)\"$")
	public WebDriver usernameandpassword(String username,String password)
	{

		lpo.getUsername().sendKeys(username);
		lpo.getPassword().sendKeys(password);
		log.info("User entered username and password");
		lpo.getLogin().click();
		log.info("User logged in");
		return driver;
	}
	
	@Then("^Home Page is navigated and user logged out$")
	public void click()
	{

		
		hpo=new HomePageObjects(driver);
		hpo.getLogout();
		log.info("User logged out");
		
		driver.close();
	}
	
	


}