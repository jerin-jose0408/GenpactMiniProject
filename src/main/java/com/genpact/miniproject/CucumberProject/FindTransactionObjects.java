package com.genpact.miniproject.CucumberProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**Contains all the page objects of Find Transaction Page
 * 
 * @author 703316032
 *
 */
public class FindTransactionObjects {
	public WebDriver driver;	
	public FindTransactionObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	By findByAmount=By.cssSelector("[id='criteria.amount']");
	By findTransaction=By.cssSelector("[ng-click*='AMOUNT']");
	By transactionResult=By.cssSelector(".title");

	public WebElement getAmount()
	{
		return driver.findElement(findByAmount);
	}
	public WebElement getTransaction()
	{
		return driver.findElement(findTransaction);
	}
	public String getTransactionReult()
	{
		return driver.findElement(transactionResult).getText();
	}



}
