package pageObjects;


import org.openqa.selenium.WebElement;

import utils.SeleniumDriver;

/**
 * Contains elements for Lets talk tea page
 * @author Jose Bernhardt
 *
 */
public class LetsTalkTea_Page {


	private SeleniumDriver seleniumDriver = new SeleniumDriver();
	

	public boolean isMapFrameDisplayed() {
		String xpath = "//div[@class = 'wsb-element-map']";
		return seleniumDriver.getElementByXpath(xpath).isDisplayed();
	}
	
	public boolean isEmailFormDisplayed() {
		String xpath = "//div[@class = 'form ']";
		return seleniumDriver.getElementByXpath(xpath).isDisplayed();
	}
	
	public int getAmountOfRequireFields() {
		String xpath = "//span[text() = '*']";
		return seleniumDriver.getListElementByXpath(xpath).size();
	}
	
	public WebElement getNameTextInput() {
		String name = "name";
		return seleniumDriver.getElementByName(name);
	}
	
	public WebElement getEmailTextInput() {
		String name = "email";
		return seleniumDriver.getElementByName(name);
	}
	
	public WebElement getSubjectTextInput() {
		String name = "subject";
		return seleniumDriver.getElementByName(name);
	}
	
	public WebElement getMessageTextArea() {
		String name = "message";
		return seleniumDriver.getElementByName(name);
	}
	
	public WebElement getSubmitBtn() {
		String xpath = "//input[@value = 'Submit']";
		return seleniumDriver.getElementByXpath(xpath);
	}
}
