package utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Contains all basic selenium methods to be used
 * 
 * @author Jose Bernhardt
 *
 */
public class SeleniumDriver {

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private final static int MAX = 3;
	private final static String XPATH = "xpath";
	private final static String ID = "id";
	private final static String NAME = "name";

	public SeleniumDriver() {

		driver = TestBaseSetup.driver;
		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;

	}

	// - - - - - - - - - - Basic Actions - - - - - - - - - - - - - //
	// ===================================================================//

	/**
	 * custom wait time
	 */
	public static void customWait(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Navigates browser to URL specify
	 * 
	 * @param URL
	 */
	public void goToURL(String URL) {
		driver.navigate().to(URL);
	}

	/**
	 * perform a click on the element
	 * 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		
		try {
			element.click();
		} catch (StaleElementReferenceException e) {
			// Ignore
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", element);
		}

	}

	/**
	 * set a value in an element.
	 * 
	 * @param element
	 * @param value
	 *            to set
	 */
	public void setValue(WebElement element, String value) {
		
		try {
			element.click();
		} catch (Exception e) {

		}

		element.sendKeys(value);

	}

	/**
	 * wait for the HTML DOM to be ready, all elements loaded
	 * 
	 * 
	 */
	public void waitForDOMready() {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
		}

	}

	/**
	 * select an item in a drop down element by the text visible
	 * 
	 * @param element
	 * @param text
	 */
	public void selectDropDownByText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}

	/**
	 * validate the page using the url
	 * 
	 * @param expected
	 */
	public void validateUrlContains(String expected) {
		waitForDOMready();
		Assert.assertTrue(driver.getCurrentUrl().contains(expected), "URL does not match the expected: " + expected);
	}

	/**
	 * validate the page title contains the expected
	 * 
	 * @param current
	 * @param expected
	 */
	public void validatePageTitleContains(String expected) {
		waitForDOMready();
		Assert.assertTrue(driver.getTitle().contains(expected), "URL does not match the expected: " + expected);

	}

	// - - - - - - - - - - Page Object Helper - - - - - - - - - - //
	// ===================================================================//

	/**
	 * Return an element located by xpath specified
	 */
	public WebElement getElementByXpath(String xpath) {
		return getElement(xpath, XPATH);
	}

	/**
	 * Return an element located by name specified
	 */
	public WebElement getElementByName(String name) {
		return getElement(name, NAME);
	}

	/**
	 * Return an element located by id specified
	 */
	public WebElement getElementByID(String id) {
		return getElement(id, ID);
	}

	/**
	 * Return a list of elements located by xpath specified
	 */
	public List<WebElement> getListElementByXpath(String xpath) {
		return getListOfElements(xpath, XPATH);
	}

	/**
	 * Try 3 times to find an element
	 * 
	 * @param element
	 * @param by
	 * @return
	 */
	private WebElement getElement(String element, String by) {
		List<WebElement> elements = null;

		for (int i = 0; i < MAX && (elements == null || elements.size() < 1); ++i) {
			try {
				if (by.toLowerCase().equals(ID))
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(element)));
				else if (by.toLowerCase().equals(NAME))
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(element)));
				if (by.toLowerCase().equals(XPATH))
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(element)));

			} catch (Exception ex) {

			}
		}

		if (elements != null && elements.size() > 0)
			return elements.get(0);
		else
			return null;

	}

	/**
	 * Try 3 times to find a list of elements
	 * 
	 * @param element
	 * @param by
	 * @return
	 */
	private List<WebElement> getListOfElements(String element, String by) {

		List<WebElement> elements = null;
		for (int i = 0; i < MAX && (elements == null || elements.size() < 1); ++i) {
			try {
				if (by.toLowerCase().equals(NAME))
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(element)));
				else if (by.toLowerCase().equals(XPATH))
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(element)));

			} catch (Exception ex) {

			}
		}

		if (elements != null && elements.size() > 0)
			return elements;
		else
			return null;

	}

}
