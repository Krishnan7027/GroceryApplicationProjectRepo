package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	PageUtility pageUtility = new PageUtility();
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "New") WebElement createNewAdminUserButton;
	@FindBy(id = "username") WebElement usernameField;
	@FindBy(id = "password") WebElement passwordField;
	@FindBy(id = "user_type") WebElement userTypeDropdownField;
	@FindBy(name = "Create") WebElement saveNewAdminUserSaveButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement adminUserCreationSuccessMessage;
	@FindBy(xpath = "//*[@id='res']/center") WebElement adminUserSearchFailureMessage;
	
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchPageAdminUserButton;
	@FindBy(id = "un") WebElement searchUsernameField;
	@FindBy(xpath = "//select[@id='ut']") WebElement searchUserTypeDropdownField;
	@FindBy(name = "Search") WebElement submitSearchAdminUserButton;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement resetAdminUserButton;
	
	public AdminUsersPage clickOnCreateNewAdminUserButton() {
		createNewAdminUserButton.click();
		return this;
	}
	
	public AdminUsersPage clickOnSaveNewAdminUserSaveButton() {
		waitUtility.waitUntilElementToBeClickable(driver, saveNewAdminUserSaveButton);
		saveNewAdminUserSaveButton.click();
		return this;
	}
	
	public AdminUsersPage clickOnSearchAdminUserButton() {
		searchPageAdminUserButton.click();
		return this;
	}
	
	public AdminUsersPage clickOnSubmitSearchAdminUserButton() {
		submitSearchAdminUserButton.click();
		return this;
	}
	
	public AdminUsersPage clickOnResetAdminUserButton() {
		resetAdminUserButton.click();
		return this;
	}
	
	public AdminUsersPage enterAdminUsernameField(String username) {
		usernameField.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage enterAdminPasswordField(String password) {
		passwordField.sendKeys(password);
		return this;
	}
	
	public AdminUsersPage selectAdminUsertype(String value) {
//		Select sobj = new Select(userTypeDropdownField);
//		sobj.selectByValue(value);
		
		pageUtility.selectDropdownWithValue(userTypeDropdownField, value);
		return this;
	}
	
	public AdminUsersPage enterAdminUsernameSearchField(String username) {
		searchUsernameField.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage selectAdminUsertypeSearchField(String value) {
//		Select sobj = new Select(searchUserTypeDropdownField);
//		sobj.selectByValue(value);
		
		pageUtility.selectDropdownWithValue(searchUserTypeDropdownField, value);
		return this;
	}
	
	public boolean isAdminUserCreationSuccessMessageDisplayed() {
		return adminUserCreationSuccessMessage.isDisplayed();
	}
	
	public boolean isAdminUserSearchButtonDisplayed() {
		return submitSearchAdminUserButton.isDisplayed();
	}
	
	public boolean isAdminUserResetButtonDisplayed() {
		return resetAdminUserButton.isDisplayed();
	}
	
}
