package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import utils.SeleniumDriver;

/**
 * Contains all elements for Menu Page
 * @author Jose Bernhardt
 *
 */
public class Menu_Page {

	private SeleniumDriver seleniumDriver = new SeleniumDriver();
	

	public WebElement getCheckoutGreenTeaBtn() {
		String xpath = "//strong[text() = 'Green Tea']/ancestor::div[2]/following-sibling::div[2]";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public List<WebElement> getCheckoutListButtons() {
		String xpath = "//span[text() = 'Check Out']";
		return seleniumDriver.getListElementByXpath(xpath);
	}
}
