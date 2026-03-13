package automationcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class TestNgBase {

	public WebDriver driver;
	
	@BeforeMethod
	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}
	
	public void closeAndQuit() {
//		driver.close();
//		driver.quit();
	}
}
