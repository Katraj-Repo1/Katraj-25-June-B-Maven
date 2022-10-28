package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import pages.HomePage;
import pages.LoginPage;
import utility.Screenshot;

public class HomeTest extends BaseTest {
	
	HomePage hp;
	LoginPage lp;
	public ExtentTest test;
	
	@BeforeClass
	public void  objectCreation() {
		
		lp =new LoginPage(driver);
		hp= new HomePage(driver);
		
	}
	
	@BeforeClass
	public void precondition() {
		lp.enterCred("Admin", "admin123");
		lp.clickButton();
		getReporter();
	}
	
	@Test
	public void verifyTitle() {
		 test = extent.createTest("Test -Verify title ", getTimestamp());
		test.info("test step-1");
		Reporter.log("test case verify title started");
		test.info("test step-2");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title does not matched);");
		Reporter.log("test case verify title end");
	}
	
	@Test
	public void logout() {
		 test =extent.createTest("Test - Logout", getTimestamp());
			test.info("test step-1");
		Reporter.log("logout test start");
		hp.clickOnProfile();
		//hp.clickOnLogout();
		test.info("test step-2");
		Assert.assertTrue(true);
		Reporter.log("Logout test end");
	}
	@Test
	public void clickontab() {
		test =extent.createTest("Test - clickontab", getTimestamp());
		test.info("test step-1");
		hp.clickOnAdmin();
		test.info("test step-2");
		Assert.assertTrue(false);
	}
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "FAILED", ExtentColor.RED));
			test.fail(result.getThrowable()).addScreenCaptureFromPath(Screenshot.captureScreenshot(driver,  Screenshot.getCurrentDate1()));
		}
	}
	
	@AfterClass
	public void flsh() {
		extent.flush();
	}

}
