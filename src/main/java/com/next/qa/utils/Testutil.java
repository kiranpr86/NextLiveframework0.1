package com.next.qa.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.next.qa.base.Testbase;

public class Testutil extends Testbase {
	
	public static int implicit_wait_value=20;
	static ExtentReports extent;
	
	public static void takescreenshot() throws IOException
	{
		File Screenshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
	
		FileHandler.copy(Screenshotfile,new File(currentDir + "//screenshots//" + System.currentTimeMillis() + Listeners.failedmethod + ".png"));
	}

	public static ExtentReports getReportmethod()
	{
		String path = System.getProperty("user.dir") + "\\reports\\myextentreport.html";//Creating the path where reports will be created under the project folder
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);//This class will expect a path where the report should be created
		reporter.config().setReportName("Next Automation Report");//Using reporter object we are configuring the report
		reporter.config().setDocumentTitle("Next Test results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);// Now we have to attach the helper extentSparkReporter class to main class which is ExtentReports
		extent.setSystemInfo("Tester", "KiranR");//Using this method we can set the Tester name in the report
		return extent;
		
		
	}


}
