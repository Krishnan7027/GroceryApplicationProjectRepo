package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username") WebElement usernameField;
	@FindBy(name = "password") WebElement passwordField;
	@FindBy(xpath = "//button[@type = 'submit']") WebElement loginButton;
	
	public void enterUsernameField(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}

}
