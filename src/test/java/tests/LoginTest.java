package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;


public class LoginTest extends BaseTest {
	
	
	LoginPage lp;

	@BeforeClass
	public void objectCreation() {	
		//create object
		 lp = new LoginPage(driver);
		 
	
	}
	
	@Test
	public void login() {
		
		lp.enterCred("Admin", "admin123");
		
		Assert.assertTrue(lp.isEnabled(), "Button is not enabled");
		
		lp.clickButton();
		
		System.out.println("successfully login");
		
		
	}
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		
		
		
	}	

}
