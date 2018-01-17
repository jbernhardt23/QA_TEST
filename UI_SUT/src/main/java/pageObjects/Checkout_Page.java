package pageObjects;

import org.openqa.selenium.WebElement;

import utils.SeleniumDriver;

/**
 * Contains all elements for Checkout page
 * @author Jose Bernhardt
 *
 */
public class Checkout_Page {

	private SeleniumDriver seleniumDriver = new SeleniumDriver();

	public WebElement getEmailTextInput() {
		String xpath = "//label[text() = 'E-mail']/following-sibling::div//input";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement getNameTextInput() {
		String xpath = "//label[text() = 'Name']/following-sibling::div//input";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement getAddressTextArea() {
		String xpath = "//label[text() = 'Address']/following-sibling::div//textarea";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement GetCardTypeSelect() {
		String xpath = "//label[text() = 'Card Type']/following-sibling::div//select";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement getCardNumberTextInput() {
		String xpath = "//label[text() = 'Card Number']/following-sibling::div//input";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	
	public WebElement getCardHolderTextInput() {
		String xpath = "//label[text() = 'Cardholder Name']/following-sibling::div//input";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement getVerificationCodeTextInput() {
		String xpath ="//label[text() = 'Verification Code']/following-sibling::div//input";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public WebElement getPlaceOrderBtn() {
		String xpath ="//button[text() = 'Place Order']";
		return seleniumDriver.getElementByXpath(xpath);
	}
	
	public boolean isCustomerInfoFormDisplayed() {
		String xpath ="//form[@class = 'form-horizontal']//fieldset/legend[text()='Customer Info']";
		return seleniumDriver.getElementByXpath(xpath).isDisplayed();
	}
	
	public boolean isPaymentFormDisplayed() {
		String xpath ="//form[@class = 'form-horizontal']//fieldset/legend[text()='Payment']";
		return seleniumDriver.getElementByXpath(xpath).isDisplayed();
	}
}
