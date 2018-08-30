package com.googlerestapi.com.rest;

import static com.jayway.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import automation.pages.DocumentsPage;
import automation.pages.LoginPage;


public class GetStatusCodeTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setBaseUri() {
		RestAssured.baseURI = "https://qa-api.ct.wolterskluwer.com";
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://qa-ux-ctadmin.ctadvantage.com/CTAdminUX/CTWebAdmin/Public/Login.aspx");
		
//		BufferedReader br = null;
//
//        try {
//
//            String sCurrentLine;
//
//            br = new BufferedReader(new FileReader("D:\\workspace\\com.rest\\ApiData"));
//
//            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println(sCurrentLine);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (br != null)br.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }

	}
	
	@Test
	public void testStatusCode() {
//		given().when().get("http://www.google.com").then().statusCode(200);
		
		Response res = 
			given()
			.contentType("application/json")
				.headers("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIzMjAwMDEyNDM1NyIsImluZHZkbElkIjoiLTkyMjMzNzIwMzY4NTQ3NzU4MDgiLCJhY2NvdW50SWQiOiIzMDAwMDAwMDAwMSIsImFjdHZVc2VySWQiOiIzMjAwMDEyNDM1NyIsImFjdHZJZG50SWQiOiItOTIyMzM3MjAzNjg1NDc3NTgwOCIsImFjdHZBY2N0SWQiOiIzMDAwMDAwMDAwMSIsInJlYWxVc2VySWQiOiIzMjAwMDEyNDM1NyIsInJlYWxJZG50SWQiOiItOTIyMzM3MjAzNjg1NDc3NTgwOCIsInJlYWxBY2N0SWQiOiIzMDAwMDAwMDAwMSIsInJlYWxVc3JUeXAiOiIyIiwiZ3JhbnRfdHlwZSI6ImFjY2Vzc190b2tlbiIsImlzcyI6Imh0dHBzOi8vcWEtdXguaGN1ZS5jb20iLCJhdWQiOiJodHRwczovL3FhLXV4LmhjdWUuY29tIiwiZXhwIjoxNTMzODM5OTI0LCJuYmYiOjE1MzM4MzkzMjR9.QWWDvXjL3erYosxdObxDLLFcn7BsWT3Iqq0g_Vryjtc")
				.headers ("Ocp-Apim-Subscription-Key", "67a5b50931f146a8b30d08f3c3f7e64b")
			    .param("month", "5")
			    .param("year", "2018")
			    .when()
			    .get ("/hcue/Consumption-Tracker/v1/consumption-tracker/rollupdata")
			    .then()
				.contentType(ContentType.JSON)
			    .extract().response();
		
		Assert.assertEquals (res.statusCode (), 200);
		
		JsonPath jsonResponse = res.jsonPath();
		List<HashMap<String, Object>> jsonList = jsonResponse.getList("auditRollupData");
	    //System.out.println(jsonList.get(0).get("auditRollupId"));	
		int listSize = jsonList.size();
		int[] id = new int[listSize];
		for (int i = 0; i < listSize; i++) {
			id[i] = (int) jsonList.get(i).get("auditRollupId");
			System.out.println(id[i]);
		}
		
		LoginPage log = new LoginPage(driver);
		
		//DocumentsPage documents = log.populateAndSubmitLoginPageExpectingMyHomePage()
		


	    //System.out.println (res.asString ());

		
			    
	}

//	@Test
//	public void testStatusCodeRestAssured () {
//
//	given ().contentType("application/json")
//		.headers("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIzMjAwMDEyNDM1NyIsImluZHZkbElkIjoiLTkyMjMzNzIwMzY4NTQ3NzU4MDgiLCJhY2NvdW50SWQiOiIzMDAwMDAwMDAwMSIsImFjdHZVc2VySWQiOiIzMjAwMDEyNDM1NyIsImFjdHZJZG50SWQiOiItOTIyMzM3MjAzNjg1NDc3NTgwOCIsImFjdHZBY2N0SWQiOiIzMDAwMDAwMDAwMSIsInJlYWxVc2VySWQiOiIzMjAwMDEyNDM1NyIsInJlYWxJZG50SWQiOiItOTIyMzM3MjAzNjg1NDc3NTgwOCIsInJlYWxBY2N0SWQiOiIzMDAwMDAwMDAwMSIsInJlYWxVc3JUeXAiOiIyIiwiZ3JhbnRfdHlwZSI6ImFjY2Vzc190b2tlbiIsImlzcyI6Imh0dHBzOi8vcWEtdXguaGN1ZS5jb20iLCJhdWQiOiJodHRwczovL3FhLXV4LmhjdWUuY29tIiwiZXhwIjoxNTMzMDcwMjgxLCJuYmYiOjE1MzMwNjk2ODF9.xP_ffv7TRJJKO2ERQKxBN5qbOEL1QR41D7AgKqu-TRQ")
//		.headers ("Ocp-Apim-Subscription-Key", "67a5b50931f146a8b30d08f3c3f7e64b")
//	    .param("month", "6")
//	    .param("year", "2018")
//        .when()
//        .get ("/hcue/Consumption-Tracker/v1/consumption-tracker/rollupdata?year=2018&month=6")
//        .then ()
//        .assertThat ().statusCode (200);
//
//	}
	

}
