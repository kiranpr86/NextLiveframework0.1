package com.next.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.next.qa.base.Testbase;
import com.qa.next.pages.HomePage;
import com.qa.next.pages.LoginPage;

public class LoginPageTest extends Testbase {
	
	public HomePage homepageobject;
	public LoginPage loginpageobject;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		homepageobject=new HomePage();
		homepageobject.MyAccountLinkClick();
		loginpageobject=new LoginPage();
	}
	
	@Test
	public void loginTest()
	{
		loginpageobject.signin();
	}
	
	@Test
	public void RegisternowclickTest()
	{
		loginpageobject.Registernowclick();
	}

	@AfterMethod
	public void Teardown()
	{
		driver.close();
	}


}
