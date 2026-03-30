package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement createNewNewsButton;
	@FindBy(id = "news") WebElement newsField;
	@FindBy(name = "create") WebElement submitNewNewsButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement newsCreationSuccessMessage;
	@FindBy(xpath = "//*[@id='res']/center") WebElement newsSearchFailureMessage;
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchNewsButton;
	@FindBy(name = "un") WebElement searchNewsField;
	@FindBy(name = "Search") WebElement submitSearchNewsButton;
	
	@FindBy(xpath = "/html/body/div/div[1]/section/div[1]/a[3]") WebElement resetNewsButton;

	public void clickOnCreateNewNewsButton() {
		createNewNewsButton.click();
	}
	
	public ManageNewsPage clickOnSubmitNewNewsButtonn() {
		submitNewNewsButton.click();
		return this;
	}
	
	public ManageNewsPage clickOnSearchNewsButton() {
		searchNewsButton.click();
		return this;
	}
	
	public ManageNewsPage clickOnSubmitSearchNewsButton() {
		submitSearchNewsButton.click();
		return this;
	}
	
	public void clickOnResetNewsButton() {
		resetNewsButton.click();
	}
	
	public ManageNewsPage enterNewsField(String news) {
		newsField.sendKeys(news);
		return this;
	}
	
	public ManageNewsPage enterSearchNewsField(String news) {
		searchNewsField.sendKeys(news);
		return this;
	}
	
	public boolean isNewsCreationSuccessMessageDisplayed() {
		return newsCreationSuccessMessage.isDisplayed();
	}
	
	public boolean isNewsSearchFailureMessageDisplayed() {
		return newsSearchFailureMessage.isDisplayed();
	}
	
}
