package utils;

import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Contains Setup for test cases.
 * 
 * @author Jose Bernhardt
 *
 */
public class TestBaseSetup {

	static WebDriver driver;
	private static final Logger logger = LogManager.getLogger(TestBaseSetup.class);
	protected JSONObject checkoutTeaTestData;
	protected JSONObject sendEmailFormTestData;

	/**
	 * Initiate ChromeDriver
	 */
	@BeforeMethod(alwaysRun = true)
	public void setupDriver() {
		logger.info("---> Starting WebDriver for Chrome");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		getTestData();

	}

	/**
	 * Tear down driver instance
	 */
	@AfterMethod(alwaysRun = true)
	public void quitDriver() {
		logger.info("---> Closing WebDriver");
		// if not sleep, driver does not get closed :(
		SeleniumDriver.customWait(3);
		driver.quit();
		driver = null;
	}

	/**
	 * Reads Json for testData input.
	 * This is for demo purposes. Data read can be more dynamic
	 */
	private void getTestData() {
		JSONParser parser = new JSONParser();
		try {
			Object obj1 = parser.parse(new FileReader("./src/main/resources/testData/testDataCheckoutTea.json"));
			Object obj2 = parser.parse(new FileReader("./src/main/resources/testData/testDataSendEmailForm.json"));
			
			  checkoutTeaTestData = (JSONObject) obj1;
			  sendEmailFormTestData = (JSONObject) obj2;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
