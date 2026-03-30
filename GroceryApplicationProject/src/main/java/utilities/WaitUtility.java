package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public static int ExplicitWait = 5;

	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void waitUntilElementSelectionStateToBe(WebDriver driver, WebElement element, boolean selected) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}

	public void waitUntilTextToBePresentInElementValue(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}

	public void waitUntilAlertIsPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait));
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
