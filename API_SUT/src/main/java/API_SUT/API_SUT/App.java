package API_SUT.API_SUT;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
/**
 * Contains all actions to be performed actions API
 * @author Jose Bernhardt
 *
 */
public class App 
{
	private final static String endpoint = "https://api.genderize.io/?";
	private static final Logger logger = LogManager.getLogger(App.class);
	
	/**
	 * Validates that status code returned for endpoint is 
	 * 200
	 */
	public void testStatusCode() {
		logger.info("============ Testing Status Code as OK ================");
		Response response = given()
		.log()
		.all()
		.when()
		.get(endpoint + "name=peter")
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
		logger.info("============ Pass: Status code "+response.getStatusCode()+ " ================");
	}
	
	/**
	 * Validates Media Type for endpoint is JSON
	 */
	public void testMediaType() {
		
		logger.info("============ Testing Media Type application/json ================");
		Response response = given()
		.log()
		.all()
		.when()
		.get(endpoint + "name=peter")
		.then()
		.assertThat()
		.contentType("application/json")
		.extract()
		.response();
		logger.info("============ Pass: Media Type "+response.getContentType()+ " ================");
	}
	
	
	/**
	 * Validates schema validation with JSON in classpath
	 */
	public void tetSchemaValidation() {

		logger.info("============ Testing JSON Scheme ================");
		 given()
		.contentType("application/json")
		.log()
		.all()
		.when()
		.get(endpoint + "name=peter")
		.then()
		.assertThat()
		.body(matchesJsonSchemaInClasspath("validation.json"));
	
		logger.info("============ Pass  ================");
		
	}
	
	/**
	 * Validates 'probability' value corresponds to a Float Value
	 */
	public void testFloatValue() {
		logger.info("============ Testing Float value in 'probability'  ================");
		Response response =
		given()
		.contentType("application/json")
		.log()
		.all()
		.when()
		.get(endpoint + "name=louis")
		.then()
		.assertThat()
		.body("probability", equalTo(0.99f))
		.extract()
		.response();
		logger.info("============ Pass: Probability value "+ (Float) response.path("probability")+ " ================");
		
	}
	
	/**
	 * Validates that a certain Object in the JSON response
	 * contains a specific key:value
	 */
	public void testComplexResponse() {
		logger.info("============ Testing JSON object properties  ================");
		Response response = given()
		.contentType("application/json")
		.log()
		.all()
		.when()
		.get(endpoint + "name[0]=peter&name[1]=lois&name[2]=stevie")
		.then()
		.assertThat()
		.body("[2].name", equalTo("stevie"))
		.body("[2].gender", equalTo("male"))
		.extract()
		.response();
		logger.info("============ Pass: "+ (String) response.path("[2].name")+","+(String) response.path("[2].gender")+" ================");
		
	}
	
}
