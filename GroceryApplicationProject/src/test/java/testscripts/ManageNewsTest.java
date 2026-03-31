package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNgBase;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNgBase {

	ManageNewsPage manageNewsObj;
	HomePage homeObj;

	@Test(priority = 1, description = "Verify whether user is able to add new news")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username).enterPasswordField(password);
		homeObj = loginObj.clickLoginButton();
		homeObj.clickOnManageNewsMoreinfoButton();
		
		String newsContent = ExcelUtility.getStringData(0,0,"ManageNewsPage");
		manageNewsObj = new ManageNewsPage(driver);
		manageNewsObj.clickOnCreateNewNewsButton();
		manageNewsObj.enterNewsField(newsContent).clickOnSubmitNewNewsButtonn();
		
		Assert.assertTrue(manageNewsObj.isNewsCreationSuccessMessageDisplayed(), Constants.NEWS_CREATION_ERROR);
	}
	
	@Test(priority = 2, description = "Verify whether user is able to search news")
	public void verifyWhetherUserIsAbleToSearchNews() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username).enterPasswordField(password);
		homeObj = loginObj.clickLoginButton();
		homeObj.clickOnManageNewsMoreinfoButton();
		
		String newsToSearch = ExcelUtility.getStringData(0,0,"ManageNewsPage");
		
		manageNewsObj = new ManageNewsPage(driver);
		manageNewsObj.clickOnSearchNewsButton();
		manageNewsObj.enterSearchNewsField(newsToSearch).clickOnSubmitSearchNewsButton();
		
		Boolean isNewsSearchButtonDisplayed = manageNewsObj.isNewsSearchButtonDisplayed();
		Assert.assertTrue(isNewsSearchButtonDisplayed, Constants.NEWS_SEARCH_ERROR);
	}
	
	@Test(priority = 3, description = "Verify whether user is able to reset news page")
	public void verifyWhetherUserIsAbleToResetNewsPage() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username);
		loginObj.enterPasswordField(password);
		homeObj = loginObj.clickLoginButton();
		homeObj.clickOnManageNewsMoreinfoButton();
		
		String newsToSearch = ExcelUtility.getStringData(0,0,"ManageNewsPage");
		
		manageNewsObj = new ManageNewsPage(driver);
		manageNewsObj.clickOnSearchNewsButton().enterSearchNewsField(newsToSearch).clickOnSubmitSearchNewsButton();
		manageNewsObj.clickOnResetNewsButton();
		
		Boolean isSearchNewsFieldButtonDisplayed = manageNewsObj.isNewsResetButtonDisplayed();
		Assert.assertTrue(isSearchNewsFieldButtonDisplayed, Constants.NEWS_RESET_ERROR);
	}
}