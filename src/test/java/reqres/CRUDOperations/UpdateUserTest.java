package reqres.CRUDOperations;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateUserTest {

	@Test
	public void updateUserTest()
	{
		//Step1 : Create pre-requisites-> body
		JSONObject obj=new JSONObject();
		obj.put("name", "morpheus");
		obj.put( "job", "zion resident");
		
		RequestSpecification request=RestAssured.given();
		request.body(obj);
		request.contentType(ContentType.JSON);
		
		//Step2: Send request
		Response response=request.patch("https://reqres.in/api/users/2");
		
		//Step3:Validate the response
		ValidatableResponse val=response.then();
		val.assertThat().statusCode(200);
		val.log().all();
	}
}
