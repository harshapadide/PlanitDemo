package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.Utils;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	public Base(){
		
	
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Automation\\planitassesment\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
 }



@SuppressWarnings("deprecation")
public static void initialization(){
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\planitassesment\\src\\main\\resources\\chromedriver.exe");	
		driver = new ChromeDriver(); 
	}
	else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "D:\\Automation\\planitassesment\\src\\main\\resources\\geckodriver.exe");	
		driver = new FirefoxDriver(); 
	}
	
	
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));

}
}
