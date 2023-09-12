/**
 * 
 */
package com.day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

/**
 * 
 */
public class AutomationTester {
int id;
@Test
public void createTester() {
	
	HashMap<String,Object> hm=new HashMap<String, Object>();
	hm.put("name", "Dada");
	hm.put("location", "India");
	hm.put("Phone", "123456");
	
	String testinArr[]= {"Postman","Automation","Manual","API"};
	hm.put("Testings", testinArr);
	id=given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("http://localhost:3000/testers")
			.jsonPath().getInt("id");
	given().when()
		.then()
			.statusCode(201)
			.body("name", equalTo("Dada"))
			.body("location", equalTo("India"))
			.body("Phone", equalTo("123456"))
			.body("Testings[0]", equalTo("Postman"))
			.body("Testings[1]", equalTo("Automation"))
			.body("Testings[2]", equalTo("Manual"))
			.body("Testings[3]", equalTo("API"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
}
@Test(priority=2)
public void getTester() {
	given()
	.when()
		.get("http://localhost:3000/testers")
		.then().statusCode(200)
		.log().all();
}
@Test(priority = 3)
public void deleteTester() {
	given()
	.when()
		.delete("http://localhost:3000/testers/"+id)
		.then()
			.statusCode(200);
}
}
