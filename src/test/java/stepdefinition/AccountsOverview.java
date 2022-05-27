package stepdefinition;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.genpact.miniproject.CucumberProject.AccountsOverviewObjects;
import com.genpact.miniproject.CucumberProject.Base;
import com.genpact.miniproject.CucumberProject.HomePageObjects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsOverview {
	
		private static Logger log=LogManager.getLogger(AccountsOverview.class.getName());
	
	HomePageObjects hpo=new HomePageObjects(Base.getDriver());
	AccountsOverviewObjects aoo=new AccountsOverviewObjects(Base.getDriver());


		//Accounts overview scenario
		@When("^User clicks on Accounts Overview$")
		public void click_On_Accounts_Overview() throws InterruptedException, IOException
		{
			
			hpo.getAccountsOverview().click();
			log.info("User navigated to Accounts overview page");
			Thread.sleep(1000);
		}
		@Then("^Verify the total matches the sum of balances$")
		public void sum_matches_total()
		{
			
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
			Base.tearDown();
		}

}
