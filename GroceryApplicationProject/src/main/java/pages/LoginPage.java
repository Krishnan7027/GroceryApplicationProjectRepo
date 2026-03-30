package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username") WebElement usernameField;
	@FindBy(name = "password") WebElement passwordField;
	@FindBy(xpath = "//button[@type = 'submit']") WebElement loginButton;
	
	//assertion element
	@FindBy(xpath = "//p[text()='Dashboard']") public WebElement dashboardText;
	@FindBy(xpath = "//b[text()='7rmart supermarket']") public WebElement supermarketText;
	@FindBy(xpath = "//button[text()='Sign In']") public WebElement signinButton;
	
	public LoginPage enterUsernameField(String username) {
		usernameField.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPasswordField(String password) {
		passwordField.sendKeys(password);
		return this;
	}
	
	public HomePage clickLoginButton() {
		waitUtility.waitUntilElementToBeClickable(driver, loginButton);
		loginButton.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardTextDisplayed() {
		return dashboardText.isDisplayed();
	}
	
	public String isSupermarketTextDisplayed() {
		return supermarketText.getText();
	}
	
	public boolean isSignInButtonDisplayed() {
		return signinButton.isDisplayed();
	}

}
