package com.genpact.miniproject.CucumberProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**Contains all the page objects of Accounts Overview Page
 * 
 * @author 703316032
 *
 */
public class AccountsOverviewObjects {



	public WebDriver driver;	
	public AccountsOverviewObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	By secondColumn=By.cssSelector("td:nth-child(2)");

	public java.util.List<WebElement> getSecondColumn() 
	{

		return driver.findElements(secondColumn);

	} 




}
