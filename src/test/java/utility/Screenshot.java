package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	
	public static String captureScreenshot(WebDriver driver, String name) throws IOException {
		
		//step -1 use of takeScreenShot interface
				TakesScreenshot tss= (TakesScreenshot) driver;
				
				//step-2 calling getScreenShot
				File sourceFile =tss.getScreenshotAs(OutputType.FILE);
				
				//step-3 path of location where we want to store screenshot
				String path = System.getProperty("user.dir")+"\\Screenshots\\"+name+".jpg";
				
				//step -4 file class
				File destinationFile = new File (path);
				
				//step-5
				FileHandler.copy(sourceFile, destinationFile);
				
				return path;
		
	}
	
	public static String getCurrentDate1() {
		
		SimpleDateFormat time =new SimpleDateFormat("yyyyMMdd_HHmmss");
		Date date =Calendar.getInstance().getTime();
		String currentTime = time.format(date);
		
		return currentTime;
		
	}
	


}
