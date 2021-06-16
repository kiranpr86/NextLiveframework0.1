package com.next.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.next.qa.utils.Testutil;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase()
	{
		prop=new Properties();
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\kiran R\\eclipse-workspaceKiran\\NextLiveframework\\src\\main\\java\\com\\next\\qa\\config\\config.properties");//need to fix the hard code value
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kiran R\\Downloads\\chromedriver\\chromedriver.exe");//need to fix the hard code value
			driver=new ChromeDriver();
		}
	  
		else if(browserName.equals("C:\\Webdriver path\\geckodriver.exe"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Webdriver path\\chromedriver.exe");//need to fix the hard code value
			driver=new ChromeDriver();
		}
	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Testutil.implicit_wait_value,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	
	
	}
	

}
