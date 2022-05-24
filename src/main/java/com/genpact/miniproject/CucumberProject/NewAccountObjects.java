package com.genpact.miniproject.CucumberProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**Contains all the page objects of New Account Objects Page
 * 
 * @author 703316032
 *
 */
public class NewAccountObjects {

	public WebDriver driver;	
	Select dropdown,dropdown1;
	WebElement staticdropdown,staticdropdown1;
	public NewAccountObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	By accountType=By.cssSelector("#type");
	By accountId=By.cssSelector("#fromAccountId");
	By openNewAccount=By.cssSelector("input[value*='Open']");
	By accountOpened=By.xpath("//h1[normalize-space()='Account Opened!']");




	public void setAccountType(String type)
	{
		staticdropdown=driver.findElement(accountType);
		dropdown=new Select(staticdropdown);	
		dropdown.selectByVisibleText(type);
	}

	public void setAccountId(int index) throws InterruptedException
	{
		staticdropdown1=driver.findElement(accountId);
		dropdown1=new Select(staticdropdown1);	
		dropdown1.selectByIndex(index);

	}

	public WebElement getOpenNewAccount() throws InterruptedException
	{
		WebDriverWait wd=new WebDriverWait(driver,Duration.ofSeconds(5));
		wd.until(ExpectedConditions.visibilityOfElementLocated(openNewAccount));

		return driver.findElement(openNewAccount);
	}

	public String accountGetText() throws InterruptedException
	{

		return driver.findElement(accountOpened).getText();

	}
}
