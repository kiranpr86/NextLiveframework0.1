package com.next.qa.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	
	public static String failedmethod;//We are using this failedmethod in Testutil class for screenshot
	ExtentReports extent=Testutil.getReportmethod();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		String TCname=result.getMethod().getMethodName();
		test=extent.createTest(TCname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String Passedmethod=result.getMethod().getMethodName();
		test.log(Status.PASS, Passedmethod + " TC Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println("Execution Failed-from OnTestFailure");
		failedmethod=result.getMethod().getMethodName();
		test.log(Status.FAIL, failedmethod + " TC Passed");
		System.out.println("This " + failedmethod + " is failed");
		
		try {
			Testutil.takescreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();

	}

}
