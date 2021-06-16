package com.next.qa.testcases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.next.qa.base.Testbase;
import com.qa.next.pages.HomePage;

public class HomePageTest extends Testbase {
	public static Logger log=LogManager.getLogger(HomePageTest.class.getName());
	public HomePage homepageobject;
	
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		
		initialization();
		log.info("initialization done");
		homepageobject=new HomePage();
	}
	
	@Test
	public void Logotest()
	{
	Assert.assertEquals(homepageobject.ValidateHomepageLanding(), true);
	}
	
	@Test
	public void MyAccountLinkClickTest()
	{
		homepageobject.MyAccountLinkClick();
	}
	
	@Test
	public void WomenmousehoverTest() throws InterruptedException
	{
		homepageobject.departmentmousehover();
		Thread.sleep(3000);
	}
	
	@Test
	public void searchboxTest() throws InterruptedException
	{
		homepageobject.searchcategory();
	}
	
	
	@AfterMethod
	public void Teardown()
	{
		driver.close();
	}

}
