package testscripts;

import java.io.IOException;
import org.testng.annotations.Test;

import pages.LoginPage;
import automationcore.TestNgBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNgBase {

	@Test(priority = 1, description = "verify User Login With Valid Credentials")
	public void verifyUserLoginWithValidCredentials() throws IOException {	
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username);
		pageObj.enterPasswordField(password);
		pageObj.clickLoginButton();
	}
	
	@Test(priority = 2, description = "verify User Login With Invalid Credentials")
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(1,0,"LoginPage");
		String password = ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username);
		pageObj.enterPasswordField(password);
		pageObj.clickLoginButton();
	}
	
	@Test(priority = 3, description = "verify User Login With Invalid Username Valid Password")
	public void verifyUserLoginWithInvalidUsernameValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2,0,"LoginPage");
		String password = ExcelUtility.getStringData(2,1,"LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username);
		pageObj.enterPasswordField(password);
		pageObj.clickLoginButton();
	}
	
	@Test(priority = 4, description = "verify User Login With Valid Username Invalid Password")
	public void verifyUserLoginWithValidUsernameInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(3,0,"LoginPage");
		String password = ExcelUtility.getStringData(3,1,"LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username);
		pageObj.enterPasswordField(password);
		pageObj.clickLoginButton();
	}
}
