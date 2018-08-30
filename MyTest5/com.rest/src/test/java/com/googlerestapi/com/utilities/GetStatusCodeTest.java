package MyTest6.API;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;


public class GetStatusCodeTest {
	

	@BeforeClass
	public void setBaseUri() {
		RestAssured.baseURI = "https://qa-api.ct.wolterskluwer.com";
	}
	
	@Test
	public void testStatusCode() {
	
		Response res = 
			given()
			.contentType("application/json")
				.headers("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhY3R2VXNlcklkIjoiMzIwMDAwMDQ2NDAiLCJhY3R2SWRudElkIjoiLTkyMjMzNzIwMzY4NTQ3NzU4MDgiLCJhY3R2QWNjdElkIjoiMzAwMDAwMDE0NjMiLCJSZWFsVXNlcklkIjoiMzIwMDAwMDQ2NDAiLCJyZWFsSWRudElkIjoiLTkyMjMzNzIwMzY4NTQ3NzU4MDgiLCJ1c2VySWQiOiIzMjAwMDAwNDY0MCIsImluZHZkbElkIjoiLTkyMjMzNzIwMzY4NTQ3NzU4MDgiLCJhY2NvdW50SWQiOiIzMDAwMDAwMTQ2MyIsInJlYWxBY2N0SWQiOiIzMDAwMDAwMTQ2MyIsInJlYWxVc3JUeXAiOiIzIiwiZ3JhbnRfdHlwZSI6ImFjY2Vzc190b2tlbiIsImlzcyI6Imh0dHBzOi8vcWEtdXguaGN1ZS5jb20iLCJhdWQiOiJodHRwczovL3FhLXV4LmhjdWUuY29tIiwiZXhwIjoxNTM1ODMzNzkyLCJuYmYiOjE1MDI4Mjg5OTJ9.J_ZNTrY5luWLkwd-L1T5ev-Sn6EKLrDUvBoTfVz9lXA")
				.headers ("Ocp-Apim-Subscription-Key", "c145f25d7b644b93b78b861362323600")
			    //.param("month", "5")
			    //.param("year", "2018")
			    .when()
			    .get ("/hcue/Personnel/v1/personnel")
			    .then()
				.contentType(ContentType.JSON)
			    .extract().response();
		
		Assert.assertEquals (res.statusCode (), 200);
		
		JsonPath jsonResponse = res.jsonPath();
		List<HashMap<String, Object>> jsonList = jsonResponse.getList("personnel");
	    System.out.println(jsonList.get(0).get("personnelId"));	
		
			   
	}

}
