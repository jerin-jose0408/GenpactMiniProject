package com.genpact.miniproject.CucumberProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**Contains all the page objects of Update Accounts Page
 * 
 * @author 703316032
 *
 */
public class UpdateContactInfoObjects {
	public WebDriver driver;	
	public UpdateContactInfoObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	By phoneNo=By.cssSelector("[id='customer.phoneNumber']");
	By updateProfile=By.cssSelector("[value='Update Profile']");
	By profileUpdated=By.cssSelector(".title");

	public WebElement getPhoneNo()
	{
		return driver.findElement(phoneNo);
	}
	public WebElement getUpdateProfile()
	{
		return driver.findElement(updateProfile);
	}
	public String getProfileUpdated()
	{
		return driver.findElement(profileUpdated).getText();
	}


}
