package stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genpact.miniproject.CucumberProject.AccountsOverviewObjects;
import com.genpact.miniproject.CucumberProject.Base;
import com.genpact.miniproject.CucumberProject.BillPayObjects;

import com.genpact.miniproject.CucumberProject.FindTransactionObjects;
import com.genpact.miniproject.CucumberProject.HomePageObjects;
import com.genpact.miniproject.CucumberProject.LoginPageObjects;
import com.genpact.miniproject.CucumberProject.NewAccountObjects;
import com.genpact.miniproject.CucumberProject.RequestLoanObjects;
import com.genpact.miniproject.CucumberProject.TransferFundObjects;
import com.genpact.miniproject.CucumberProject.UpdateContactInfoObjects;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.*;



public class StepDefinition extends Base{

	private static Logger log=LogManager.getLogger(StepDefinition.class.getName());
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
	@Given("^User launches \"([^\"]*)\" portal$")
	public void loginPage(String url) throws IOException
	{
		
		driver=initializeDriver();
		log.info("Browser Initialized");
		driver.get(url);
		log.info("URL entered into browser");
		driver.manage().window().maximize();
		log.info("Browser maximized");

	}
	@When("^User Logs into the application with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void usernameandpassword(String username,String password)
	{

		lpo=new LoginPageObjects(driver);
		lpo.getUsername().sendKeys(username);
		lpo.getPassword().sendKeys(password);
		log.info("User entered username and password");
		
	}
	@Test
	@Then("^Home Page is navigated and user logged out$")
	public void click()
	{

		lpo.getLogin().click();
		log.info("User logged in");
		hpo=new HomePageObjects(driver);
		hpo.getLogout();
		log.info("User logged out");
		
		driver.close();
	}
	//Create new account scenario, contains both savings and checking
	@Given("^User launches \"([^\"]*)\" portal with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void launch(String url,String username,String password) throws IOException, InterruptedException
	{

		driver=initializeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		lpo1=new LoginPageObjects(driver);
		lpo1.getUsername().sendKeys(username);
		lpo1.getPassword().sendKeys(password);
		lpo1.getLogin().click();
		log.info("User logged in");
	}
	@When("^User clicks on Open New Account with (.+) and (.+)$")
	public void openNewAccount(String type,String index) throws InterruptedException
	{
		hpo=new HomePageObjects(driver);
		hpo.getOpenNewAccount().click();
		Thread.sleep(1000);
		nao=new NewAccountObjects(driver);
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
	//Accounts overview scenario
	@When("^User clicks on Accounts Overview$")
	public void click_On_Accounts_Overview() throws InterruptedException
	{
		hpo=new HomePageObjects(driver);

		hpo.getAccountsOverview().click();
		log.info("User navigated to Accounts overview page");
		Thread.sleep(1000);
	}
	@Then("^Verify the total matches the sum of balances$")
	public void sum_matches_total()
	{
		AccountsOverviewObjects aoo=new AccountsOverviewObjects(driver);
		List<WebElement> values=aoo.getSecondColumn();
		float[] value=new float[values.size()];
		float balance=0,total=0;
		String s=null;

		for(int i=0;i<values.size();i++)
		{
			if(values.get(i).getText().charAt(0)=='-')
				s="-"+(values.get(i).getText()).substring(2);
			else
				s=(values.get(i).getText()).substring(1);	




			value[i]=Float.parseFloat(s);
			if(i<values.size()-1)
				balance+=value[i];
			else
				total=value[i];
		}
		log.info("Checking the balance amount with the total");
		Assert.assertEquals(balance, total);
		driver.close();
	}

	//Transfer funds scenario
	@When("^User transfers fund of (.+) from (.+) to (.+)$")
	public void transferFund(String amount,String from,String to) throws InterruptedException
	{
		hpo=new HomePageObjects(driver);
		hpo.getTransferFunds().click();
		Thread.sleep(3000);
		tao=new TransferFundObjects(driver);
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
		driver.close();

	}
	//Bill Pay scenario
	@When("user enters following bill pay details")
	public void user_enters_following_bill_pay_details(DataTable dataTable) throws InterruptedException {
		hpo=new HomePageObjects(driver);
		hpo.getBillPay().click();
		Thread.sleep(1000);
		List<List<String>> billPayList=dataTable.asLists(String.class);
		bpo=new BillPayObjects(driver);
		List<WebElement> inputList=bpo.getallInput();
		for(int i=0;i<inputList.size();i++)
		{
			inputList.get(i).sendKeys(billPayList.get(0).get(i)); //loop to send all inputs
		}
		Thread.sleep(1000);
		bpo.getSendPayment().click();
		Thread.sleep(1000);
		log.info("Paying Bill");
	}
	@Then("bill pay should be successful")
	public void bill_pay_should_be_successful() {
		Assert.assertEquals(bpo.getBillPayment(), "Bill Payment Complete");
		driver.close();
	}

	//Find transaction by amount scenario
	@When("User provides the amount as {string} and clicks on Find")
	public void user_provides_the_amount_as_and_clicks_on_find(String string) throws InterruptedException {
		hpo=new HomePageObjects(driver);
		fto=new FindTransactionObjects(driver);
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
		driver.close();
	}

	//Scenario to change the contact no
	@When("User changes contact no to {string}")
	public void user_changes_contact_no_to(String string) throws InterruptedException {
		hpo=new HomePageObjects(driver);
		hpo.getUpdateContactInfo().click();
		Thread.sleep(1000);
		ucio=new UpdateContactInfoObjects(driver);
		Actions a=new Actions(driver);

		Thread.sleep(1000);
		a.moveToElement(ucio.getPhoneNo()).click().keyDown(Keys.CONTROL)
		.sendKeys("A").keyUp(Keys.CONTROL).sendKeys(string).build().perform();
		Thread.sleep(1000);

		//ucio.getPhoneNo().sendKeys(string);
		Thread.sleep(1000);
		ucio.getUpdateProfile().click();
		Thread.sleep(1000);
		log.info("Updating contact details");
	}
	@Then("Verify contact details is updated")
	public void verify_contact_details_is_updated() {
		Assert.assertEquals(ucio.getProfileUpdated(),"Profile Updated");
		driver.close();
	}
	//Scenario to request loan
	@When("User requests loan amount of {string} with downpayment {string}")
	public void user_requests_loan_amount_of_with_downpayment(String amount, String downPayment) throws InterruptedException {
		hpo=new HomePageObjects(driver);
		hpo.getRequestLoan().click();
		Thread.sleep(1000);
		rlo=new RequestLoanObjects(driver);
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
		driver.close();

	}



}