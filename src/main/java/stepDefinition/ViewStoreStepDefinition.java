package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.*;

import com.api.utils.JsonReader;
import com.api.utils.TestContext;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import static io.restassured.RestAssured.*;


public class ViewStoreStepDefinition {

	private TestContext context;
	
	public ViewStoreStepDefinition(TestContext context) {
		super();
		this.context = context;
	}

	@Given("store API is available")
	public void store_api_is_available() {
		System.out.println("Given Method");
	    baseURI = "http://localhost:3030/";
	}

	@When("I invoke stores api with get method")
	public void i_invoke_stores_api_with_get_method() {
		context.response =  given().log().all().when().get("stores");
		
	    System.out.println("When Method");
	}

	//Validate the response code
	@Then("the response code should be {int}")
	public void the_response_code_should_be(Integer int1) {
	   System.out.println("Then Method");
	   System.out.println("Context.response in ViewStoreStepDefinition : "+ context.response.asString());
	   
	   Assert.assertEquals(Long.toString(context.response.statusCode()), Long.toString(int1));
	}
	
	@When("I invoke {string} api with get method")
	public void invokeSingleStoreApi(String endpoint) {
		
		context.response = given().log().all().when().get(endpoint,4);
		
	}
	
	@When("I invoke stores api with get method and {int}")
	public void i_invoke_stores_api_with_get_method(int limit) {
		context.response = (Response) given().log().all().queryParam("$limit",limit).when().get("stores");
		
	}
	
	@When("I invoke stores api with get method for single store")
	public void invokeGetMethodForSingleStore() {
	
		context.response = given().get("stores/{id}",context.storeId);
	}
	
	@Then("match the response with {string}")
	public void matchTheViewStoresResponse(String fileName) {
		
		//Reading the JSON FIle and storing the sample response in a JSONObject
		org.json.simple.JSONObject sampleResponse = JsonReader.readJsonFile(fileName);
		
		assertEquals(JsonParser.parseString(sampleResponse.toString()),JsonParser.parseString(context.response.asString()));
		
		
	}
	
	@Then("validate the response schema {string}")
	public void verifyResponseSchema(String fileName) {
		
		Assert.assertNotNull(context.response.body().jsonPath().getInt("total"));
		
		context.response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/"+fileName));
		
		
	}

}
