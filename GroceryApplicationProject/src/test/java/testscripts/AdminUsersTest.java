package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNgBase;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends TestNgBase {

	HomePage homeObj;

	@Test(priority = 1, description = "verify user is able to add new admin user successfully")
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username).enterPasswordField(password);
		homeObj = loginObj.clickLoginButton();
		homeObj.clickOnAdminUsersMoreinfoButton();

//		String usernameForNewAdminUser = ExcelUtility.getStringData(1,0,"AdminUsersPage");
//		String passwordForNewAdminUser = ExcelUtility.getStringData(1,1,"AdminUsersPage");
//		String usertypeForNewAdminUser = ExcelUtility.getStringData(1,2,"AdminUsersPage");

		FakerUtility fakerObj = new FakerUtility();
		String usernameForNewAdminUser = fakerObj.createRandomUsername();
		String passwordForNewAdminUser = fakerObj.createRandomPasssword();
		String usertypeForNewAdminUser = ExcelUtility.getStringData(1, 2, "AdminUsersPage");

		AdminUsersPage adminUserObj = new AdminUsersPage(driver);
		adminUserObj.clickOnCreateNewAdminUserButton().enterAdminUsernameField(usernameForNewAdminUser)
				.enterAdminPasswordField(passwordForNewAdminUser).selectAdminUsertype(usertypeForNewAdminUser)
				.clickOnSaveNewAdminUserSaveButton();

		Assert.assertTrue(adminUserObj.isAdminUserCreationSuccessMessageDisplayed(),
				Constants.ADMIN_USER_CREATION_ERROR);
	}

	@Test(priority = 2, description = "verify user is able to search new admin user successfully")
	public void verifyWhetherUserIsAbleToSearchNewAdminUser() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username).enterPasswordField(password);
		homeObj = loginObj.clickLoginButton();
		homeObj.clickOnAdminUsersMoreinfoButton();

		String usernameForNewAdminUser = ExcelUtility.getStringData(1, 0, "AdminUsersPage");
		String usertypeForNewAdminUser = ExcelUtility.getStringData(1, 2, "AdminUsersPage");

		AdminUsersPage adminUserObj = new AdminUsersPage(driver);
		adminUserObj.clickOnSearchAdminUserButton().enterAdminUsernameSearchField(usernameForNewAdminUser)
				.selectAdminUsertypeSearchField(usertypeForNewAdminUser).clickOnSubmitSearchAdminUserButton();

		Assert.assertTrue(adminUserObj.isAdminUserSearchButtonDisplayed(), Constants.ADMIN_USER_SEARCH_ERROR);
	}

	@Test(priority = 3, description = "verify user is able to reset admin user page successfully")
	public void verifyWhetherUserIsAbleResetAdminUserPage() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsernameField(username).enterPasswordField(password);
		homeObj = loginObj.clickLoginButton();
		homeObj.clickOnAdminUsersMoreinfoButton();

		String usernameForNewAdminUser = ExcelUtility.getStringData(1, 0, "AdminUsersPage");
		String usertypeForNewAdminUser = ExcelUtility.getStringData(1, 2, "AdminUsersPage");

		AdminUsersPage adminUserObj = new AdminUsersPage(driver);

		adminUserObj.clickOnSearchAdminUserButton().enterAdminUsernameSearchField(usernameForNewAdminUser)
				.selectAdminUsertypeSearchField(usertypeForNewAdminUser).clickOnSubmitSearchAdminUserButton()
				.clickOnResetAdminUserButton();

		Assert.assertTrue(adminUserObj.isAdminUserResetButtonDisplayed(), Constants.ADMIN_USER_RESET_ERROR);
	}

}
