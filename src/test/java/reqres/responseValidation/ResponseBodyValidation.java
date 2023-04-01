package reqres.responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ResponseBodyValidation {

	@Test
	public void getAllUsers()
	{
		baseURI="https://reqres.in/";
		Response rsp=when()
				.get("/api/unknown");
		rsp.then()
			.assertThat()
				.statusCode(200)
				.log().all();
		String actValue=rsp.jsonPath().get("data[2].name");
		Assert.assertEquals(actValue, "true red");
	}
}
