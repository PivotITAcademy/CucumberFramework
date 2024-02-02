package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import response.createStoreResponse.CreateStoreResponse;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.json.simple.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;

import com.api.utils.JsonReader;
import com.api.utils.TestContext;


public class CreateStoreStepDefinition {

	private TestContext context;
	
	
	public CreateStoreStepDefinition(TestContext context) {
		super();
		this.context = context;
	}

	Map<String, String> reqParamsMap =null;

	JSONObject requestObject;
	
	@When("I invoke stores api with post method")
	public void invokeStoresApiWithPostMethod() {
		
		Response response = given().log().all().contentType("application/json").body(requestObject.toString()).when().post("stores");
		context.response = response;
		
		System.out.println("Context.response in CreateStoreDefinition : "+ context.response.asString());
	}
	
	@Given("create request for the method using following values")
	public void createRequest(DataTable datatable) {
		
		 reqParamsMap = datatable.asMaps().get(0);
		
		requestObject = new JSONObject();
		requestObject.put("name",reqParamsMap.get("name"));
		requestObject.put("address",reqParamsMap.get("address"));
		requestObject.put("city",reqParamsMap.get("city"));
		requestObject.put("state",reqParamsMap.get("state"));
		requestObject.put("zip",reqParamsMap.get("zip"));
		
	}
	

	
	@Given("populate the request with json from {string}")
	public void createRequestFromjson(String fileName) {
		
		requestObject = JsonReader.readJsonFile(fileName)	;
		
	}
	
	@Then("extract the storeId")
	public void extractStoreIdFromResponse() {
		context.storeId = context.response.body().jsonPath().getInt("id");
		System.out.println("context.storeId : "+context.storeId);
		
	}
	
	@Then("verify the response details")
	public void verifyResponseDetails() {
		
		
		
		//Convert my response to pojo class
		CreateStoreResponse createStoreResponse = context.response.body().as(CreateStoreResponse.class);
		//Get name value from requestObject and compare it with values in response 
		
		Assert.assertEquals(createStoreResponse.getName(), requestObject.get("name"));
		Assert.assertEquals(createStoreResponse.getAddress(), requestObject.get("address"));
		Assert.assertEquals(createStoreResponse.getCity(), requestObject.get("city"));
		Assert.assertEquals(createStoreResponse.getState(), requestObject.get("state"));
		
	}
}
