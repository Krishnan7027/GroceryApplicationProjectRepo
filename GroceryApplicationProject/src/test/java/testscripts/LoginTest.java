package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import automationcore.TestNgBase;
import constant.Constants;
import utilities.ExcelUtility;

public class LoginTest extends TestNgBase {

	HomePage homePageObj;
	
	@Test(priority = 1, description = "verify User Login With Valid Credentials", groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username).enterPasswordField(password);
		homePageObj = pageObj.clickLoginButton();

		boolean isDashboardTextDisplayed = pageObj.isDashboardTextDisplayed();
		Assert.assertTrue(isDashboardTextDisplayed, Constants.VALID_CREDENTIAL_ERROR);
	}

	@Test(priority = 2, description = "verify User Login With Invalid Credentials", groups = { "smoke" })
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username).enterPasswordField(password).clickLoginButton();

		String actualSupermarketText = pageObj.isSupermarketTextDisplayed();
		String expectedSupermarketText = "7rmart supermarket";
		Assert.assertEquals(actualSupermarketText, expectedSupermarketText,Constants.INVALID_CREDENTIAL_ERROR);
	}

	@Test(priority = 3, description = "verify User Login With Invalid Username Valid Password")
	public void verifyUserLoginWithInvalidUsernameValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username).enterPasswordField(password).clickLoginButton();

		boolean isSignInButtonDisplayed = pageObj.isSignInButtonDisplayed();
		Assert.assertTrue(isSignInButtonDisplayed,Constants.INVALID_USERNAME_VALID_PASSWORD_ERROR);
	}

	@Test(priority = 4, dataProvider = "loginProvider" , description = "verify User Login With Valid Username Invalid Password")
	public void verifyUserLoginWithValidUsernameInvalidPassword(String username, String password) throws IOException {
//		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
//		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		
		LoginPage pageObj = new LoginPage(driver);
		pageObj.enterUsernameField(username).enterPasswordField(password).clickLoginButton();

		boolean isSignInButtonDisplayed = pageObj.isSignInButtonDisplayed();
		Assert.assertTrue(isSignInButtonDisplayed,Constants.VALID_USERNAME_INVALID_PASSWORD_ERROR);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
// 		new Object[] {ExcelUtility.getStringData(3,0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}
