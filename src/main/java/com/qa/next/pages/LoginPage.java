package com.qa.next.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.next.qa.base.Testbase;

public class LoginPage extends Testbase {
	
	
	@FindBy(name="EmailOrAccountNumber")
	WebElement Emailid;
	
	@FindBy(name="Password")
	WebElement Password;
	
	@FindBy(name="SignInNow")
	WebElement SignInButton;
	
	@FindBy(css="a[href*='secure/account/Register']")
	WebElement Registernow;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

public void signin()
{
	Emailid.sendKeys(prop.getProperty("username"));
	Password.sendKeys("password");
	SignInButton.click();
}


public RegisternowPage Registernowclick()
{
	Registernow.click();
	
	return new RegisternowPage();
}

}
