package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenshotUtility;

public class TestNgBase {

	Properties prop;
	FileInputStream fileInput;
	public WebDriver driver;
	
//	@BeforeMethod(alwaysRun = true) //for grouping purpose
	@BeforeMethod
	@Parameters("browserName")
	public void browserLaunch(String browserName) throws Exception {
		
		prop = new Properties();
		fileInput = new FileInputStream(Constants.CONFIG_FILE_PATH);
		prop.load(fileInput);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid browser name provided: " + browserName);
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		//implicit wait command
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
//	@AfterMethod(alwaysRun = true) //for grouping purpose
	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException { 
		  
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
 			ScreenshotUtility screenShot = new ScreenshotUtility(); 
 			screenShot.getScreenshot(driver, iTestResult.getName()); 
 		} 
 		
 		driver.quit(); 
 	}
}
