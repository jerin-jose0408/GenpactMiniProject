package stepdefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.genpact.miniproject.CucumberProject.Base;
import com.genpact.miniproject.CucumberProject.BillPayObjects;
import com.genpact.miniproject.CucumberProject.HomePageObjects;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BillPay {
	private static Logger log=LogManager.getLogger(BillPay.class.getName());
	HomePageObjects hpo=new HomePageObjects(Base.getDriver());
	BillPayObjects bpo=new BillPayObjects(Base.getDriver());
	//Bill Pay scenario
	@When("user enters following bill pay details")
	public void user_enters_following_bill_pay_details(DataTable dataTable) throws InterruptedException {
		
		hpo.getBillPay().click();
		Thread.sleep(1000);
		List<List<String>> billPayList=dataTable.asLists(String.class);
		
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
		Base.tearDown();
	}

}
