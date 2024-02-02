package stepDefinition;

import io.cucumber.java.en.When;

import static io.restassured.RestAssured.*;

import com.api.utils.TestContext;

public class DeleteStoreStepDefinition {

	private TestContext context;
	
	
	public DeleteStoreStepDefinition(TestContext testContext) {
		this.context=testContext;
	}


	@When("I invoke stores api with delete method for single store")
	public void deleteStore() {
		context.response = given().delete("stores/{id}",context.storeId);
	}
}
