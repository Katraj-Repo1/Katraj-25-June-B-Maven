package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports extent;

	
	@BeforeSuite
	public void init() throws IOException, InterruptedException {
		
		//step-1 
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito"); 
		
		//step-2
		driver = new ChromeDriver(options);
		
		//step-3 maximize window
		driver.manage().window().maximize();
	
		//step-4 open webpage
		driver.get(readProperty("URL"));
		
		//step-5 implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("browser launch successfully");
	}
	
	public static String readProperty(String v) throws IOException, InterruptedException {
		
		String path ="C:\\Users\\Admin\\eclipse-workspace\\Katraj-25-June-B-Maven\\src\\test\\resources\\config.properties";
		Properties prop =new Properties();
		
		FileInputStream fis =new FileInputStream(path);
		
		prop.load(fis);
		Thread.sleep(2000);
		
		String val = prop.getProperty(v);
		
		return val;
	}
	

    public void getReporter() {
    	
    	spark = new ExtentSparkReporter("C:\\Users\\Admin\\eclipse-workspace\\Katraj-25-June-B-Maven\\reporter\\Spark.html");
    	
    	 extent = new ExtentReports();
    	 
    	 extent.attachReporter(spark);
    	 
    	 spark.config().setEncoding("utf-8");
    	 spark.config().setDocumentTitle("Spark Reporter");
    	 spark.config().setProtocol(Protocol.HTTPS);
    	 spark.config().setReportName("Reporter1");
    	 spark.config().setTheme(Theme.STANDARD);
    	 spark.config().setTimeStampFormat("dd-M-yyyy hh:mm:ss");
    	 
    	 
    }
    
    public static String getTimestamp() {
    	
    	SimpleDateFormat format1 =new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    	Date date =Calendar.getInstance().getTime();
    	String val = format1.format(date);
    	return val;
    }
	
	@AfterSuite
	public void tearDown() {
		
		driver.close();
	}

}
