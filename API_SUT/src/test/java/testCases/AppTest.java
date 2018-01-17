package testCases;

import API_SUT.API_SUT.App;
import org.testng.annotations.Test;

/**
 * Unit test for API Test.
 */
public class AppTest {

	private App app;
	
	@Test()
	public void testStatusCode() {
		app = new App();
		app.testStatusCode();
		
	}
	
	@Test()
	public void testMediaType() {
		app = new App();
		app.testMediaType();
		
	}
	
	@Test()
	public void testSchemeValidation() {
		app = new App();
		app.tetSchemaValidation();
		
	}
	
	@Test()
	public void testFloatValue() {
		app = new App();
		app.testFloatValue();
		
	}
	
	@Test()
	public void testComplexResponse() {
		app = new App();
		app.testComplexResponse();
		
	}
}
