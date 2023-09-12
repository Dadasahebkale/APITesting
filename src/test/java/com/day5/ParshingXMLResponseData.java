package com.day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class ParshingXMLResponseData {
	@Test(priority=1)
	public void testXMLResponse() { // 
		
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation.name[0]", equalTo("Developer"))
		.body("TravelerinformationResponse.travelers.Travelerinformation.email[0]", equalTo("Developer12@gmail.com"));
		
	}
	@Test(priority = 2)
	public void testXMLPathMethod() {
		
	Response res=given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");
		String travelName=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(travelName, "Developer");
		String traveleremail=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].email").toString();
		Assert.assertEquals(traveleremail, "Developer12@gmail.com");
	}
}
