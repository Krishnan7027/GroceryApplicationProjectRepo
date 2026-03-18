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
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchNewsButton;
	@FindBy(name = "un") WebElement searchNewsField;
	@FindBy(name = "Search") WebElement submitSearchNewsButton;
	
	@FindBy(xpath = "/html/body/div/div[1]/section/div[1]/a[3]") WebElement resetNewsButton;

	public void clickOnCreateNewNewsButton() {
		createNewNewsButton.click();
	}
	
	public void clickOnSubmitNewNewsButtonn() {
		submitNewNewsButton.click();
	}
	
	public void clickOnSearchNewsButton() {
		searchNewsButton.click();
	}
	
	public void clickOnSubmitSearchNewsButton() {
		submitSearchNewsButton.click();
	}
	
	public void clickOnResetNewsButton() {
		resetNewsButton.click();
	}
	
	public void enterNewsField(String news) {
		newsField.sendKeys(news);
	}
	
	public void enterSearchNewsField(String news) {
		searchNewsField.sendKeys(news);
	}
	
	
}
