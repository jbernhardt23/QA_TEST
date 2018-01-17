package testCases;


import org.testng.annotations.Test;
import baseModules.PracticeSeleniumBase;
import utils.TestBaseSetup;

/**
 * Functional Test for Website Practice Selenium
 * 
 * @author Jose Bernhardt
 *
 */
public class PracticeSeleniumTestCases extends TestBaseSetup {

	private PracticeSeleniumBase base;
	

	@Test()
	public void doCheckoutGreenTea() {
	
		base = new PracticeSeleniumBase();
		base.openPracticeSeleniumPage();
		base.doGreenTeaCheckOut(checkoutTeaTestData);

	}

	@Test()
	public void doVerifyPageSections() {
		
		base = new PracticeSeleniumBase();
		base.openPracticeSeleniumPage();
		base.doVerifyPageSections();

	}
	
	@Test()
	public void sendEmailForm() {
		
		base = new PracticeSeleniumBase();
		base.openPracticeSeleniumPage();
		base.sendAnEmailForm(sendEmailFormTestData);

	}
	

}
