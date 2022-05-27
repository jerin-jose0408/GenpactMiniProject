package stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.genpact.miniproject.CucumberProject.Base;
import com.genpact.miniproject.CucumberProject.HomePageObjects;
import com.genpact.miniproject.CucumberProject.UpdateContactInfoObjects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateContact {
	
	HomePageObjects hpo=new HomePageObjects(Base.getDriver());
	UpdateContactInfoObjects ucio=new UpdateContactInfoObjects(Base.getDriver());
	
	private static Logger log=LogManager.getLogger(UpdateContact.class.getName());
	//Scenario to change the contact no
		@When("User changes contact no to {string}")
		public void user_changes_contact_no_to(String string) throws InterruptedException {
			
			hpo.getUpdateContactInfo().click();
			Thread.sleep(1000);
			
			Actions a=new Actions(Base.getDriver());

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
			Base.tearDown();
		}

}
