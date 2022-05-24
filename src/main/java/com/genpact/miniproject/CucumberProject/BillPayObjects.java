package com.genpact.miniproject.CucumberProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**Contains all the page objects of Bill Pay Page
 * 
 * @author 703316032
 *
 */
public class BillPayObjects {

	public WebDriver driver;	
	public BillPayObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	By allInput=By.cssSelector("input[class*='ng-pristine']");
	By sendPayment=By.cssSelector("input[type='submit']");
	By billPaymentComplete=By.cssSelector("div [ng-show='showResult'] h1[class='title']");
	public List<WebElement> getallInput()
	{
		return driver.findElements(allInput);
	}
	public WebElement getSendPayment()
	{
		return driver.findElement(sendPayment);
	}
	public String getBillPayment()
	{
		return driver.findElement(billPaymentComplete).getText();
	}


}
