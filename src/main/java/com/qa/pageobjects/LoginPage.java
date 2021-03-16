package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class LoginPage extends Base{
	
	//Page Factory - ObjectRepository:
	
	@FindBy(linkText="Log in")
	WebElement login;
	
	@FindBy(xpath = "//h1[contains(.,'Welcome, Please Sign In!')]")
	WebElement welcomemessage;
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="Password")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement Login;
	
	//Initializing the Page Objects:
	
	
	public LoginPage() {
		
		 
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	
	public void clickOnLogin()
	{
		login.click();
	}
	public String validateWelcomeMessage() {
		
		
		return welcomemessage.getText().toString();
	}
	
	public HomePage login(String username,String password) {
		
		email.sendKeys(username);
		Password.sendKeys(password);
		Login.click();
		return new HomePage();
		
	}

}
