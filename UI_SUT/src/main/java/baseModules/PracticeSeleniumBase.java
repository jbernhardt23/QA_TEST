package baseModules;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.Checkout_Page;
import pageObjects.Commons_PO;
import pageObjects.LetsTalkTea_Page;
import pageObjects.Menu_Page;
import pageObjects.Welcome_Page;
import utils.SeleniumDriver;

/**
 * Contains all steps and methods to be performed in the practice selenium site
 * page.
 * 
 * @author Jose Bernhardt
 *
 */
public class PracticeSeleniumBase {

	private static final Logger logger = LogManager.getLogger(PracticeSeleniumBase.class);
	private SeleniumDriver seleniumDriver = new SeleniumDriver();
	private Welcome_Page welcomePO = new Welcome_Page();
	private Checkout_Page checkoutPO = new Checkout_Page();
	private Menu_Page menuPO = new Menu_Page();
	private Commons_PO commonPO = new Commons_PO();
	private LetsTalkTea_Page letsPO = new LetsTalkTea_Page();

	/**
	 * Navigates to the practice website
	 */
	public void openPracticeSeleniumPage() {
		logger.info("---> Opening Practice Selenium");
		seleniumDriver.goToURL("http://www.practiceselenium.com");
		seleniumDriver.waitForDOMready();
		logger.info("---> Validating we are at the correct URL");
		seleniumDriver.validateUrlContains("practiceselenium");
		logger.info("---> Validated");

	}

	/**
	 * Performs all actions to complete a Green Tea checkout
	 */
	public void doGreenTeaCheckOut(JSONObject testData) {
		
		
		logger.info("---> Testing a Green tea checkout");
		seleniumDriver.clickElement(welcomePO.getHerbalTeaSeeCollectionBtn());
		seleniumDriver.clickElement(menuPO.getCheckoutGreenTeaBtn());
		seleniumDriver.setValue(checkoutPO.getEmailTextInput(), (String) testData.get("email"));
		seleniumDriver.setValue(checkoutPO.getNameTextInput(),(String) testData.get("name"));
		seleniumDriver.setValue(checkoutPO.getAddressTextArea(), (String) testData.get("address"));
		seleniumDriver.selectDropDownByText(checkoutPO.GetCardTypeSelect(),  (String) testData.get("cardType"));
		seleniumDriver.setValue(checkoutPO.getCardNumberTextInput(),(String) testData.get("cardNumber"));
		seleniumDriver.setValue(checkoutPO.getCardHolderTextInput(), (String) testData.get("cardHolder"));
		seleniumDriver.setValue(checkoutPO.getVerificationCodeTextInput(),(String) testData.get("verificationCode"));
		seleniumDriver.clickElement(checkoutPO.getPlaceOrderBtn());
		seleniumDriver.waitForDOMready();
		logger.info("---> Green tea checkout order placed");
		logger.error("---> No confirmation displayed for order placed");

	}

	/**
	 * Performs all actions in order to verify page sections
	 */
	public void doVerifyPageSections() {
		logger.info("---> Testing page sections");
		seleniumDriver.clickElement(commonPO.getWelcomeLink());
		logger.info("---> Verifying correct URL and Collections buttons for Welcome page");
		seleniumDriver.validateUrlContains("welcome");
		seleniumDriver.validatePageTitleContains("Welcome");
		List<WebElement> list = welcomePO.getSeeCollectionListButtons();
		if (list == null || list.size() < 3)
			Assert.fail("Collections buttons are not present or incomplete");

		logger.info("---> Validated");

		seleniumDriver.clickElement(commonPO.getOurPassionLink());
		logger.info("---> Verifying correct URL and Title for Our Passion Page");
		seleniumDriver.validateUrlContains("our-passion");
		seleniumDriver.validatePageTitleContains("Our Passion");
		logger.info("---> Validated");

		seleniumDriver.clickElement(commonPO.getMenuLink());
		logger.info("---> Verifying correct URL and Checkout buttons for Menu Page");
		seleniumDriver.validateUrlContains("menu");
		seleniumDriver.validatePageTitleContains("Menu");
		List<WebElement> list2 = menuPO.getCheckoutListButtons();
		if (list2 == null || list2.size() < 3)
			Assert.fail("Checkout buttons are not present or incomplete");

		logger.info("---> Validated");

		seleniumDriver.clickElement(commonPO.getLetsTalkTeaLink());
		logger.info("---> Verifying correct URL and Forms-Map are displayed for Lets Talk Tea page");
		seleniumDriver.validateUrlContains("let-s-talk-tea");
		seleniumDriver.validatePageTitleContains("Let's Talk Tea");
		if (!letsPO.isMapFrameDisplayed())
			Assert.fail("Map not displayed");
		if (!letsPO.isEmailFormDisplayed())
			Assert.fail("Form not displayed");
		logger.info("---> Validated");
		logger.info("---> Amount of require fields displayed: " + letsPO.getAmountOfRequireFields());

		seleniumDriver.clickElement(commonPO.getCheckOutLink());
		logger.info("---> Verifying correct URL and Customer/Payment forms are displayed for Checkout page");
		seleniumDriver.validateUrlContains("check-out");
		seleniumDriver.validatePageTitleContains("Check Out");
		if (!checkoutPO.isCustomerInfoFormDisplayed())
			Assert.fail("Customer info form not displayed");
		if (!checkoutPO.isPaymentFormDisplayed())
			Assert.fail("Payment form not displayed");
		logger.info("---> Validated");

	}

	/**
	 * Performs all actions in order to send an email form
	 */
	public void sendAnEmailForm(JSONObject testData) {
		logger.info("---> Testing on sending an email form");
		seleniumDriver.clickElement(commonPO.getLetsTalkTeaLink());
		seleniumDriver.validateUrlContains("let-s-talk-tea");
		seleniumDriver.validatePageTitleContains("Let's Talk Tea");
		logger.info("---> Filling Email form");

		seleniumDriver.setValue(letsPO.getNameTextInput(),  (String) testData.get("name"));
		seleniumDriver.setValue(letsPO.getEmailTextInput(),  (String) testData.get("email"));
		seleniumDriver.setValue(letsPO.getSubjectTextInput(),  (String) testData.get("subject"));
		seleniumDriver.setValue(letsPO.getMessageTextArea(), (String) testData.get("message"));

		logger.info("---> Submit button clicked");
		seleniumDriver.clickElement(letsPO.getSubmitBtn());
		if (letsPO.getSubmitBtn().isDisplayed())
			Assert.fail("Submit still present, no action was done ");

	}

}
