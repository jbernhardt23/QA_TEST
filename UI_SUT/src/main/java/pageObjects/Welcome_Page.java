package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import utils.SeleniumDriver;

/**
 * Contains all elements for Welcome Page
 * @author Jose Bernhardt
 *
 */
public class Welcome_Page {
	
	private SeleniumDriver seleniumDriver = new SeleniumDriver();
	
	
	public WebElement getHerbalTeaSeeCollectionBtn() {
		String xpath = "//span[text()= 'Herbal Tea']/ancestor::div[2]/preceding-sibling::div[4]";
		return seleniumDriver.getElementByXpath(xpath);
	}
	

	public List<WebElement> getSeeCollectionListButtons() {
		String xpath = "//span[text()='See Collection']";
		return seleniumDriver.getListElementByXpath(xpath);
	}

}
