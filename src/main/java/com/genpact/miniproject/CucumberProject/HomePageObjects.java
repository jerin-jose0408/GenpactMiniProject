package com.genpact.miniproject.CucumberProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**Contains all the page objects of Home Page
 * 
 * @author 703316032
 *
 */
public class HomePageObjects {


	public WebDriver driver;	
	public HomePageObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	By openNewAccount=By.cssSelector("a[href*='account']");
	By accountsOverview=By.cssSelector("a[href*='overview']");
	By transferFunds=By.cssSelector("a[href*='transfer']");
	By billPay=By.cssSelector("a[href*='billpay']");
	By findTransactions=By.cssSelector("a[href*='findtrans']");
	By updateContactInfo=By.cssSelector("a[href*='updateprofile']");
	By requestLoan=By.cssSelector("a[href*='requestloan']");
	By logout=By.cssSelector("a[href*='logout']");

	public WebElement getOpenNewAccount()
	{
		WebDriverWait wd=new WebDriverWait(driver,Duration.ofSeconds(5));
		wd.until(ExpectedConditions.visibilityOfElementLocated(openNewAccount));
		return driver.findElement(openNewAccount);
	}

	public WebElement getAccountsOverview()
	{
		return driver.findElement(accountsOverview);
	}

	public WebElement getBillPay()
	{
		return driver.findElement(billPay);
	}
	public WebElement getFindTransactions()
	{
		return driver.findElement(findTransactions);
	}

	public WebElement getUpdateContactInfo()
	{
		return driver.findElement(updateContactInfo);
	}

	public WebElement getTransferFunds()
	{
		return driver.findElement(transferFunds);
	}

	public WebElement getRequestLoan()
	{
		return driver.findElement(requestLoan);
	}

	public WebElement getLogout()
	{
		return driver.findElement(logout);
	}
}
