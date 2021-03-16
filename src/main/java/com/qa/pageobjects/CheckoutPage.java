package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Base;

public class CheckoutPage extends Base{
	//Page Factory - ObjectRepository:
	
	@FindBy(id="billing-address-select")
	WebElement billing;
	
	
	@FindBy(name="BillingNewAddress.FirstName")
	WebElement firstname;
	
	@FindBy(name="BillingNewAddress.LastName")
	WebElement lastname;
	
	@FindBy(name="BillingNewAddress.Email")
	WebElement email;
	
	@FindBy(name="BillingNewAddress.CountryId")
	WebElement countryid;
	
	@FindBy(name="BillingNewAddress.City")
	WebElement cityname;
	
	@FindBy(name="BillingNewAddress.Address1")
	WebElement address;
	
	@FindBy(name="BillingNewAddress.ZipPostalCode")
	WebElement postalcode;
	
	@FindBy(name="BillingNewAddress.PhoneNumber")
	WebElement phonenumber;
	
	
	@FindBy(xpath = "//input[contains(@onclick,'Billing.save()')]")
	WebElement billingsave;
	
	@FindBy(id="shipping-address-select")
	WebElement shipping;
	
	@FindBy(name="ShippingNewAddress.FirstName")
	WebElement sfirstname;
	
	@FindBy(name="ShippingNewAddress.LastName")
	WebElement slastname;
	
	@FindBy(name="ShippingNewAddress.Email")
	WebElement semail;
	
	@FindBy(name="ShippingNewAddress.CountryId")
	WebElement scountryid;
	
	@FindBy(name="ShippingNewAddress.City")
	WebElement scityname;
	
	@FindBy(name="ShippingNewAddress.Address1")
	WebElement saddress;
	
	@FindBy(name="ShippingNewAddress.ZipPostalCode")
	WebElement spostalcode;
	
	@FindBy(name="ShippingNewAddress.PhoneNumber")
	WebElement sphonenumber;
	
	@FindBy(xpath = "//input[contains(@onclick,'Shipping.save()')]")
	WebElement shippingsave;
	
	@FindBy(xpath = "//input[contains(@id,'1')][@type='radio']")
	WebElement shippingmethod;
	
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	WebElement shippingmethodsave;
	
	@FindBy(id="paymentmethod_0")
	WebElement paymentmethod;
	
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	WebElement paymentsave;
	
	@FindBy(xpath = "//p[contains(.,'You will pay by COD')]")
	WebElement paybycod;
	
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	WebElement paymentinfosave;
	
	@FindBy(xpath = "//input[contains(@value,'Confirm')]")
	WebElement orderconfirm;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[1]/div[1]/strong")
	WebElement orderid;
	
	@FindBy(linkText="Log out")
	WebElement logout;
	
	
	@FindBy(linkText="Click here for order details.")
	WebElement orderdetails;
	
	//Initializing the Page Objects:
	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public void billingadress(String ftname,String ltname,String mail,String countryname ,String city,String Adrs,String zip, String number) {
		Select baddress = new Select(billing);
		baddress.selectByVisibleText("New Address");
		firstname.clear();
		firstname.sendKeys(ftname);
		lastname.clear();
		lastname.sendKeys(ltname);
		email.clear();
		email.sendKeys(mail);
		Select Country = new Select(countryid);
		Country.selectByVisibleText(countryname);
		cityname.sendKeys(city);
		address.sendKeys(Adrs);
		postalcode.sendKeys(zip);
		phonenumber.sendKeys(number);
		billingsave.click();
		
		
	}
	
	public void shippingadress(String sftname,String sltname,String smail,String scountryname ,String scity,String sAdrs,String szip, String snumber)
	{
		Select shippingadd = new Select(shipping);
		shippingadd.selectByVisibleText("New Address");
		sfirstname.clear();
		sfirstname.sendKeys(sftname);
		slastname.clear();
		slastname.sendKeys(sltname);
		semail.clear();
		semail.sendKeys(smail);
		Select Country = new Select(scountryid);
		Country.selectByVisibleText(scountryname);
		scityname.sendKeys(scity);
		saddress.sendKeys(sAdrs);
		spostalcode.sendKeys(szip);
		sphonenumber.sendKeys(snumber);
		shippingsave.click();

		
	}
	public void shippingmethod()
	{
		shippingmethod.click();
		shippingmethodsave.click();
	}
	
	public void payment()
	{
		paymentmethod.click();
		paymentsave.click();
	}
	public String validatepaybycod() {
		
		return paybycod.getText().toString();
	}
	public void paymentinfo()
	{
		paymentinfosave.click();
	}
	
	public void orderconfirmation()
	{
		orderconfirm.click();
	}
	
	public void clickonorderdetails()
	{
		orderdetails.click();
	}
	
	public String validateorderid()
	{
		return orderid.getText().toString();
	}
	
	public void logingout()
	{
		logout.click();
	}
	
	
	
	
	
	
	
	

}
