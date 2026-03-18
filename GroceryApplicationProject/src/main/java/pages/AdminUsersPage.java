package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "New") WebElement createNewAdminUserButton;
	@FindBy(id = "username") WebElement usernameField;
	@FindBy(id = "password") WebElement passwordField;
	@FindBy(id = "user_type") WebElement userTypeDropdownField;
	@FindBy(name = "Create") WebElement saveNewAdminUserSaveButton;
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchPageAdminUserButton;
	@FindBy(id = "un") WebElement searchUsernameField;
	@FindBy(xpath = "//select[@id='ut']") WebElement searchUserTypeDropdownField;
	@FindBy(name = "Search") WebElement submitSearchAdminUserButton;
	
	@FindBy(linkText = "Reset") WebElement resetAdminUserButton;
	
	public void clickOnCreateNewAdminUserButton() {
		createNewAdminUserButton.click();
	}
	
	public void clickOnSaveNewAdminUserSaveButton() {
		saveNewAdminUserSaveButton.click();
	}
	
	public void clickOnSearchAdminUserButton() {
		searchPageAdminUserButton.click();
	}
	
	public void clickOnSubmitSearchAdminUserButton() {
		submitSearchAdminUserButton.click();
	}
	
	public void clickOnResetAdminUserButton() {
		resetAdminUserButton.click();
	}
	
	public void enterAdminUsernameField(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterAdminPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void selectAdminUsertype(String value) {
		Select sobj = new Select(userTypeDropdownField);
		sobj.selectByValue(value);
	}
	
	public void enterAdminUsernameSearchField(String username) {
		searchUsernameField.sendKeys(username);
	}
	
	public void selectAdminUsertypeSearchField(String value) {
		Select sobj = new Select(searchUserTypeDropdownField);
		sobj.selectByValue(value);
	}
	
}
