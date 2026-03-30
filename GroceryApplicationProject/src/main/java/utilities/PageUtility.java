package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	//Dropdown Button Events
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectDropdownWithVisibleText(WebElement element, String visibleText) {
		Select object = new Select(element);
		object.selectByVisibleText(visibleText);
	}

	public void selectDropdownWithIndex(WebElement element, int index) {
		Select object = new Select(element);
		object.selectByIndex(index);
	}

	// Mouse Event
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	// Keyboard Events
	public void pressEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	public void pressTab(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

}