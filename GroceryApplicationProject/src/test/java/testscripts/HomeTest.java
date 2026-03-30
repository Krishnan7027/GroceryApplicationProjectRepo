package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNgBase;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import retrymechanism.Retry;
import utilities.ExcelUtility;

public class HomeTest extends TestNgBase{

	HomePage homePageObj;

	@Test(retryAnalyzer = Retry.class , description = "verify user is able to logout successfully")
	public void verifyUserIsAbleToSuccessfullyLogout() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username).enterPasswordField(password);
		homePageObj = loginObj.clickLoginButton();
		
		homePageObj.clickOnAdminIcon();
		loginObj = homePageObj.clickOnLogoutButton();
		
		String actualSupermarketText = loginObj.isSupermarketTextDisplayed();
		String expectedSupermarketText = "7rmart supermarket";
		Assert.assertEquals(actualSupermarketText, expectedSupermarketText, Constants.LOGOUT_ERROR);
	}
}
