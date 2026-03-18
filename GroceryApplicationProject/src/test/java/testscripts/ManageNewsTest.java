package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNgBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNgBase {

	@Test(priority = 1, description = "Verify whether user is able to add new news")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username);
		loginObj.enterPasswordField(password);
		loginObj.clickLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.clickOnManageNewsMoreinfoButton();
		
		String newsContent = ExcelUtility.getStringData(0,0,"ManageNewsPage");
		
		ManageNewsPage manageNewsObj = new ManageNewsPage(driver);
		manageNewsObj.clickOnCreateNewNewsButton();
		manageNewsObj.enterNewsField(newsContent);
		manageNewsObj.clickOnSubmitNewNewsButtonn();
		
	}
	
	@Test(priority = 2, description = "Verify whether user is able to search news")
	public void verifyWhetherUserIsAbleToSearchNews() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username);
		loginObj.enterPasswordField(password);
		loginObj.clickLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.clickOnManageNewsMoreinfoButton();
		
		String newsToSearch = ExcelUtility.getStringData(0,0,"ManageNewsPage");
		
		ManageNewsPage manageNewsObj = new ManageNewsPage(driver);
		manageNewsObj.clickOnSearchNewsButton();
		manageNewsObj.enterSearchNewsField(newsToSearch);
		manageNewsObj.clickOnSubmitSearchNewsButton();
		
	}
	
	@Test(priority = 3, description = "Verify whether user is able to reset news page")
	public void verifyWhetherUserIsAbleToResetNewsPage() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username);
		loginObj.enterPasswordField(password);
		loginObj.clickLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.clickOnManageNewsMoreinfoButton();
		
		String newsToSearch = ExcelUtility.getStringData(0,0,"ManageNewsPage");
		
		ManageNewsPage manageNewsObj = new ManageNewsPage(driver);
		manageNewsObj.clickOnSearchNewsButton();
		manageNewsObj.enterSearchNewsField(newsToSearch);
		manageNewsObj.clickOnSubmitSearchNewsButton();
		
		manageNewsObj.clickOnResetNewsButton();
		
	}
}