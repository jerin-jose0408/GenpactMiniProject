package com.genpact.miniproject.CucumberProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**Contains all the page objects of Tranfer Funds Page
 * 
 * @author 703316032
 *
 */
public class TransferFundObjects {

	public WebDriver driver;	
	Select dropdown,dropdown1;
	WebElement staticdropdown,staticdropdown1;
	public TransferFundObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	By amount=By.cssSelector("#amount");
	By fromAccountId=By.cssSelector("#fromAccountId");
	By toAccountId=By.cssSelector("#toAccountId");
	By tranfer=By.cssSelector("input[value='Transfer']");
	By tranferComplete=By.cssSelector(".title");
	public WebElement getAmount() 
	{

		return driver.findElement(amount);

	} 

	public void setfromAccount(String from)
	{
		staticdropdown=driver.findElement(fromAccountId);
		dropdown=new Select(staticdropdown);	
		dropdown.selectByVisibleText(from);
	}

	public void setToAccount(String to) throws InterruptedException
	{
		staticdropdown1=driver.findElement(toAccountId);
		dropdown1=new Select(staticdropdown1);	
		dropdown1.selectByIndex(Integer.parseInt(to));

	}

	public WebElement getTransfer() throws InterruptedException
	{

		return driver.findElement(tranfer);
	}
	public String getTranferComplete()
	{
		return driver.findElement(tranferComplete).getText();
	}


}
