package pageObjects;

import org.openqa.selenium.WebElement;

import utils.SeleniumDriver;

/**
 * Contains commons elements for the website
 * @author Jose Bernhardt
 *
 */
public class Commons_PO {

private SeleniumDriver seleniumDriver = new SeleniumDriver();
	

	public WebElement getWelcomeLink() {
		String xpath = "//a[text()='Welcome']";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement getOurPassionLink() {
		String xpath = "//a[text()='Our Passion']";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement getMenuLink() {
		String xpath = "//a[text()='Menu']";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement getLetsTalkTeaLink() {
		String xpath = "//a[contains(text(),'Talk Tea')]";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement getCheckOutLink() {
		String xpath = "//a[text()='Check Out']";
		return seleniumDriver.getElementByXpath(xpath);
	}
}
