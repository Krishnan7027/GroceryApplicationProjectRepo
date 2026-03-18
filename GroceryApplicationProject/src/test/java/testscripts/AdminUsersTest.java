package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNgBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends TestNgBase {

	@Test
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username);
		loginObj.enterPasswordField(password);
		loginObj.clickLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.clickOnAdminUsersMoreinfoButton();
		
//		String usernameForNewAdminUser = ExcelUtility.getStringData(1,0,"AdminUsersPage");
//		String passwordForNewAdminUser = ExcelUtility.getStringData(1,1,"AdminUsersPage");
//		String usertypeForNewAdminUser = ExcelUtility.getStringData(1,2,"AdminUsersPage");
		
		FakerUtility fakerObj = new FakerUtility();
		String usernameForNewAdminUser = fakerObj.createRandomUsername();
		String passwordForNewAdminUser = fakerObj.createRandomPasssword();
		String usertypeForNewAdminUser = ExcelUtility.getStringData(1,2,"AdminUsersPage");
		
		AdminUsersPage adminUserObj = new AdminUsersPage(driver);
		adminUserObj.clickOnCreateNewAdminUserButton();
		adminUserObj.enterAdminUsernameField(usernameForNewAdminUser);
		adminUserObj.enterAdminPasswordField(passwordForNewAdminUser);
		adminUserObj.selectAdminUsertype(usertypeForNewAdminUser);
		adminUserObj.clickOnSaveNewAdminUserSaveButton();
		
	}
	
	@Test
	public void verifyWhetherUserIsAbleToSearchNewAdminUser() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username);
		loginObj.enterPasswordField(password);
		loginObj.clickLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.clickOnAdminUsersMoreinfoButton();
		
		String usernameForNewAdminUser = ExcelUtility.getStringData(1,0,"AdminUsersPage");
		String usertypeForNewAdminUser = ExcelUtility.getStringData(1,2,"AdminUsersPage");
		
		AdminUsersPage adminUserObj = new AdminUsersPage(driver);
		adminUserObj.clickOnSearchAdminUserButton();
		adminUserObj.enterAdminUsernameSearchField(usernameForNewAdminUser);
		adminUserObj.selectAdminUsertypeSearchField(usertypeForNewAdminUser);
		adminUserObj.clickOnSubmitSearchAdminUserButton();
		
	}
	@Test
	public void verifyWhetherUserIsAbleResetAdminUserPage() throws IOException {
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username);
		loginObj.enterPasswordField(password);
		loginObj.clickLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.clickOnAdminUsersMoreinfoButton();
		
		String usernameForNewAdminUser = ExcelUtility.getStringData(1,0,"AdminUsersPage");
		String usertypeForNewAdminUser = ExcelUtility.getStringData(1,2,"AdminUsersPage");
		
		AdminUsersPage adminUserObj = new AdminUsersPage(driver);
		
		adminUserObj.clickOnSearchAdminUserButton();
		adminUserObj.enterAdminUsernameSearchField(usernameForNewAdminUser);
		adminUserObj.selectAdminUsertypeSearchField(usertypeForNewAdminUser);
		adminUserObj.clickOnSubmitSearchAdminUserButton();
		
		adminUserObj.clickOnResetAdminUserButton();

	}
	
}
