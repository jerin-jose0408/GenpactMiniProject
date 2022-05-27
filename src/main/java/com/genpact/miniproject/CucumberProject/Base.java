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
	static Properties prop=new Properties();

	private static Base base;
	

	@SuppressWarnings("deprecation")
	public Base() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();

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
		
	}
	
	public static WebDriver getDriver()
	{
		return Base.driver;
		
	}
	
	public static void setupDriver() throws IOException
	{
		if(base==null)
		{
			base=new Base();
		}
	}
	
	public static void tearDown()
	{
		base=null;
		driver.quit();
	}

}
