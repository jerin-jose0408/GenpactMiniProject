package com.genpact.miniproject.CucumberProject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**Contains all the page objects of Login Page
 * 
 * @author 703316032
 *
 */
public class LoginPageObjects {

	public WebDriver driver;	
	public LoginPageObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	By username=By.cssSelector("input[name='username']");
	By password=By.cssSelector("input[name='password']");
	By login=By.cssSelector("input[type='submit']");

	public WebElement getUsername()
	{
		return driver.findElement(username);
	}

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}



}
