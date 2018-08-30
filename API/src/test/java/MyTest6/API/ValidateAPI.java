package MyTest6.API;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import junit.framework.Assert;

public class ValidateAPI {
	APIValidations apv = new APIValidations();
	@BeforeClass
	public void setBaseUri() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}
	
	@Test
	public void testStatusCode() {
		Response res = 
			given()
			.contentType("application/json")
			    .when()
			    .get ("/posts")
			    .then()
				.contentType(ContentType.JSON)
			    .extract().response();
		
		Assert.assertTrue(apv.validate_status(res.getStatusCode()));

		Assert.assertTrue(apv.validate_resp_time(res.getTimeIn(TimeUnit.MILLISECONDS)));
		
		JsonPath jsonResponse = res.jsonPath();
		List<HashMap<String, Object>> jsonlist = jsonResponse.getList("");
		Assert.assertTrue(apv.validate_string(jsonlist, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));	   
	}
}
