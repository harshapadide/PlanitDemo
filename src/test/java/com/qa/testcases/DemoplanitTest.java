package com.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pageobjects.CartPage;
import com.qa.pageobjects.CheckoutPage;
import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.LoginPage;
import com.qa.util.Utils;

public class DemoplanitTest extends Base{
	
	LoginPage loginpage;
	HomePage homePage;
	CartPage cartpage;
	CheckoutPage checkout;
	
	@BeforeMethod
	public void setup() {

		initialization();
		
		driver.findElement(By.linkText("Log in")).click();
		homePage = new HomePage();
		loginpage = new LoginPage();
		cartpage = new CartPage();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void demotest()
	{
		//validating login message
		String message=loginpage.validatewelcomemessage();
		Assert.assertEquals(message, "Welcome, Please Sign In!");
		
		System.out.println("login success message"+""+message);
		
		
		//login with test credetials
		 homePage = new HomePage();
		 homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 
		 //validating accountid
		 String accountid= homePage.validateaccountid();
		 Assert.assertEquals(accountid, "atest@gmail.com");
		 System.out.println("accountid"+"" + accountid);
			
		 //clicking on shopping cart
		 driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 homePage.shoppingcart();
			
		 
		 //clear the shopping cart
		 homePage.emptycart();
			 
		 //clicking on books
		 driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);	 
		 homePage.clickonbooks();
		
		 // scrolling the page
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,300)");
			
		 //selecting the books
		 driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 homePage.selectabook();
		
		 //getting price details
		 String pricedetail = homePage.getpricedetails();
		 System.out.println("pricedetails"+"" + pricedetail);
		
		 //quantity increment
		 homePage.Increasequantity();
			
		 //adding items to cart
		 driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 homePage.addtocart();
			
		 //validating addto cart message
		 String successmessage = homePage.validatemessage();
		 Assert.assertEquals(successmessage, "The product has been added to your shopping cart");
		 System.out.println("successmessage"+"" + successmessage);
		
		 //clicking on shoping cart link
		 driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 cartpage = homePage.shoppingcart();
			
		 //validating the subtotal
		 String subtotal = cartpage.total();
	     Assert.assertEquals(subtotal, subtotal);
		 System.out.println("subtotal"+"" + subtotal);
		 
		 //checking termsofservice
		 driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 cartpage.termsofservice();
		 checkout =  cartpage.checkout();
		 
						
		//filling billing details				
		 driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 checkout.billingadress(prop.getProperty("ftname"),prop.getProperty("ltname"),prop.getProperty("mail"),prop.getProperty("countryname"),prop.getProperty("city"),prop.getProperty("Adrs"),prop.getProperty("zip"),prop.getProperty("number"));
		 
		 //filling shipping details
		 driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		  checkout.shippingadress(prop.getProperty("sftname"),prop.getProperty("sltname"),prop.getProperty("smail"),prop.getProperty("scountryname"),prop.getProperty("scity"),prop.getProperty("sAdrs"),prop.getProperty("szip"),prop.getProperty("snumber"));
		 
		  //selecting shipping method
		  checkout.shippingmethod();
		  
		  //selecting payment method
		  checkout.payment();
		  
		  //validating paybycod message
		  
		  String paybycod = checkout.validatepaybycod();
		  Assert.assertEquals(paybycod, "You will pay by COD");
		  System.out.println("payment"+"" + paybycod);
		   
		  //saving the paymentinformation
		  checkout.paymentinfo();
		  checkout.orderconfirmation();
		  checkout.clickonorderdetails();
		   
		  //printing the the orderid
		  String orderid = checkout.validateorderid();
		  System.out.println("orderid"+"" +  orderid);
		   
		  //logging out from application
		  checkout.logingout();
		            
	}
		  @AfterMethod
		  public void closeapp()
		  
		     {
			  
          	driver.quit();
		     }
		            	 
	}


