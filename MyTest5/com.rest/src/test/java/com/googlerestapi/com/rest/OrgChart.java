package com.googlerestapi.com.rest;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.googlerestapi.com.utilities.ReadPropertiesFile;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import automation.pages.LoginPage;
import automation.pages.OrgChartPage;

public class OrgChart {
	
WebDriver driver;
ReadPropertiesFile rp = null;

	@BeforeClass
	public void setBaseUri() throws IOException {
		rp = new ReadPropertiesFile();
		RestAssured.baseURI = rp.getBaseURI();
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(rp.getUIURL());

	}
	
	@Test
	public void testStatusCode() {
//		given().when().get("http://www.google.com").then().statusCode(200);
		
		Response res = 
			given()
			.contentType("application/json")
				.headers("Authorization","Bearer " + rp.getToken() )
				.headers ("Ocp-Apim-Subscription-Key", rp.getSubscriptionKey())
			    .when()
			    .get (rp.getAPI())
			    .then()
				.contentType(ContentType.JSON)
			    .extract().response();
		
		Assert.assertEquals (res.statusCode (), 200);
		
		JsonPath jsonResponse = res.jsonPath();
		List<HashMap<String, Object>> jsonList = jsonResponse.getList("entities");
	    //System.out.println(jsonList.get(0).get("auditRollupId"));	
		int listSize = jsonList.size();
		String[] id = new String[listSize];
		for (int i = 0; i < listSize; i++) {
			id[i] = (String) jsonList.get(i).get("name");
			System.out.println(id[i]);
		}
		
		LoginPage log = new LoginPage(driver);
		
		OrgChartPage chart = log.populateAndSubmitLoginPageExpectingMyHomePage()
				.populateAndSubmitHomePageExpectingOrgChartPage()
				.populateAndSubmitOrgChartPage();
		
		//Assert.assertTrue(chart.isHeaderPresent(), "Header was not present");
		


	    //System.out.println (res.asString ());
			    
	}

}
