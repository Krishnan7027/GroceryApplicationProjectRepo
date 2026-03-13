package testscripts;

import java.io.IOException;
import org.testng.annotations.Test;

import pages.LoginPage;
import automationcore.TestNgBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNgBase {

	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException {	
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username);
		pageObj.enterPasswordField(password);
		pageObj.clickLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(1,0,"LoginPage");
		String password = ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username);
		pageObj.enterPasswordField(password);
		pageObj.clickLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithInvalidUsernameValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2,0,"LoginPage");
		String password = ExcelUtility.getStringData(2,1,"LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username);
		pageObj.enterPasswordField(password);
		pageObj.clickLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithValidUsernameInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(3,0,"LoginPage");
		String password = ExcelUtility.getStringData(3,1,"LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username);
		pageObj.enterPasswordField(password);
		pageObj.clickLoginButton();
	}
}
