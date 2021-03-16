package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class HomePage extends Base{
	
	//Page Factory - ObjectRepository:
	@FindBy(xpath = "//a[@href='/customer/info'][contains(.,'atest@gmail.com')]")
	WebElement accountid;
	

	@FindBy(linkText="Shopping cart")
	WebElement cart;
	
	@FindBy(xpath = "//input[@name='removefromcart']")
	WebElement remove;
	
	@FindBy(name="updatecart")
	WebElement update;
	
	@FindBy(linkText="BOOKS")
	WebElement books;
	
	@FindBy(linkText = "Computing and Internet")
	WebElement computing;
	
	@FindBy(xpath = "//span[@itemprop='price'][contains(.,'10.00')]")
	WebElement pricedetails;
	
	@FindBy(name = "addtocart_13.EnteredQuantity")
	WebElement Quantity;
	
	@FindBy(id = "add-to-cart-button-13")
	WebElement Add;
	
	@FindBy(xpath = "//p[contains(@class,'content')]")
	WebElement message;
	
	
	//Initializing the Page Objects:
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateaccountid()
	{
		return accountid.getText().toString();
	}
	
	public void emptycart()
	{
		cart.click();
		remove.click();
		update.click();
		
	}
	
	public void clickonbooks() 
   {
	books.click();
		 
	}
	
	public void selectabook()
	{
		computing.click();
	}
	
	public String getpricedetails()
	{
		return pricedetails.getText().toString();
	}
	
	public Object Increasequantity()
	{
		Quantity.clear();
		 Quantity.sendKeys("3");
		return new Object();
		
	}
	
	public void addtocart()
	{
		Add.click();
		
	}
	
	public String validatemessage() {
		return message.getText().toString();
	}
	
	public CartPage shoppingcart()
	{
		cart.click();
		return new CartPage();
	}
	
}
