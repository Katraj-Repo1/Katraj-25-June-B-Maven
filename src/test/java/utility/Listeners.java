package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.BaseTest;

public class Listeners extends BaseTest implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
		
		
		try {
			Screenshot.captureScreenshot(driver, Screenshot.getCurrentDate1());
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
