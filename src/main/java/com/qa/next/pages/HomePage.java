package com.qa.next.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.next.qa.base.Testbase;
import com.next.qa.utils.Testutil;

public class HomePage extends Testbase {
	
	@FindBy(xpath="//a[@class='SiteLogo gold']")
	WebElement Logo;
	
	@FindBy(xpath="//a[contains(@title,'Sign in to ')]")
	WebElement 	MyAccount;
	
	@FindBy(xpath="//a[@title='WOMEN']")
	WebElement 	Womendepartment;
	
	@FindBy(xpath="//input[@id='sli_search_1']")
	WebElement searchbox;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

public boolean ValidateHomepageLanding()
{
	return Logo.isDisplayed();
	
}

public LoginPage MyAccountLinkClick() 
{
	MyAccount.click();
	
	return new LoginPage();
}

public void departmentmousehover()
{
	
	Actions A=new Actions(driver);
	A.moveToElement(Womendepartment).build().perform();
}
public void searchcategory() throws InterruptedException
{
	searchbox.sendKeys("dresses");
	List<WebElement> options=driver.findElements(By.xpath("//ul[@class='search dropdown']/li"));
	for(WebElement option :options)
	{
		if(option.getText().equalsIgnoreCase("prom dress"))
		{
			option.click();
			break;
		}
	}
}


}
