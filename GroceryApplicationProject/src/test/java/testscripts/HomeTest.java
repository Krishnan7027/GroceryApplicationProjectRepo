package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNgBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNgBase{

	@Test
	public void verifyUserIsAbleToSuccessfullyLogout() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username);
		loginObj.enterPasswordField(password);
		loginObj.clickLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.clickOnAdminIcon();
		homeObj.clickOnLogoutButton();
		
	}
}
