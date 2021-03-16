package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pageobjects.CartPage;
import com.qa.pageobjects.CheckoutPage;
import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.LoginPage;

public class DemoplanitTest extends Base{

	LoginPage loginpage;
	HomePage homePage;
	CartPage cartpage;
	CheckoutPage checkout;

	@BeforeMethod
	public void setup() {

		initialization();
		homePage = new HomePage();
		loginpage = new LoginPage();
		cartpage = new CartPage();
	}

	@Test
	public void demotest()
	{

		loginpage.clickOnLogin();
		//validating login message
		String message=loginpage.validateWelcomeMessage();
		Assert.assertEquals(message, "Welcome, Please Sign In!");

		System.out.println("login success message"+""+message);

		//login with test credetials
		homePage = new HomePage();
		homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		//validating accountid
		String accountid= homePage.validateAccountId();
		Assert.assertEquals(accountid, "atest@gmail.com");
		System.out.println("accountid"+"" + accountid);

		//clicking on shopping cart

		homePage.shoppingCart();


		//clear the shopping cart
		homePage.emptyCart();

		//clicking on books

		homePage.clickOnBooks();

		

		//selecting the books

		homePage.selectaBook();

		//getting price details
		String pricedetail = homePage.getPriceDetails();
		System.out.println("pricedetails"+"" + pricedetail);

		//quantity increment
		homePage.increaseQuantity();

		//adding items to cart

		homePage.addToCart();

		//validating addto cart message
		String successmessage = homePage.validateMessage();
		Assert.assertEquals(successmessage, "The product has been added to your shopping cart");
		System.out.println("successmessage"+"" + successmessage);

		//clicking on shoping cart link

		cartpage = homePage.shoppingCart();

		//validating the subtotal
		String subtotal = cartpage.total();
		Assert.assertEquals(subtotal, subtotal);
		System.out.println("subtotal"+"" + subtotal);

		//checking termsofservice

		cartpage.termsOfService();
		checkout =  cartpage.checkOut();


		//filling billing details				

		checkout.billingAdress(prop.getProperty("ftname"),prop.getProperty("ltname"),prop.getProperty("mail"),prop.getProperty("countryname"),prop.getProperty("city"),prop.getProperty("Adrs"),prop.getProperty("zip"),prop.getProperty("number"));

		//filling shipping details

		checkout.shippingAdress(prop.getProperty("sftname"),prop.getProperty("sltname"),prop.getProperty("smail"),prop.getProperty("scountryname"),prop.getProperty("scity"),prop.getProperty("sAdrs"),prop.getProperty("szip"),prop.getProperty("snumber"));

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


