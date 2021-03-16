package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class CartPage extends Base{
	
	//Page Factory - ObjectRepository:
	
	
	@FindBy(xpath = "//span[@class='product-price'][contains(.,'30.00')]")
	WebElement subtotal;
	
	@FindBy(id="termsofservice")
	WebElement termsofservice;
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	
	//Initializing the Page Objects:
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	
	public String total() {
		return subtotal.getText().toString();
	}
	
	public void termsOfService()
	{
		termsofservice.click();
	}
	
	public CheckoutPage checkOut()
	{
		checkout.click();
		return new CheckoutPage();
	}
}
