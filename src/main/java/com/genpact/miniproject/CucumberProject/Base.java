package com.genpact.miniproject.CucumberProject;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**Contains the base class which has all the initialization functionality
 * 
 * @author 703316032
 *
 */
public class Base {
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();

		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//Initialize for firefox
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			//Initialize for IE
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
}
