package com.genpact.miniproject.CucumberProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**Contains all the page objects of Request Loan Page
 * 
 * @author 703316032
 *
 */
public class RequestLoanObjects {

	public WebDriver driver;	
	public RequestLoanObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	By amount=By.cssSelector("#amount");
	By downPayment=By.cssSelector("#downPayment");
	By applyNow=By.cssSelector("[value*='Apply']");
	By loanRequestProcessed=By.cssSelector(".title");

	public WebElement getAmount()
	{
		return driver.findElement(amount);
	}
	public WebElement getDownPayment()
	{
		return driver.findElement(downPayment);
	}
	public String getLoanRequestProcessed()
	{
		return driver.findElement(loanRequestProcessed).getText();
	}
	public WebElement getApplyNow()
	{
		return driver.findElement(applyNow);
	}



}
