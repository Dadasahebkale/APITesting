/**
 * 
 */
package com.day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

/**
 * given() => content type,set cookies, add auth, add param, set headers info etc...
 * when()=> we are adding request type in when method like get, post, put, delete
 * then()=> we are adding validation status codes, extract response,response body and header cookies etc..
 * 
 */
public class HttpRequestStudent {
	int id;
	@Test(priority = 1)
	public void getStudent() {
		
		given()
			.when()
				.get("http://localhost:3000/students/1")
			.then()
				.statusCode(200)
				//.body("page",equalTo(2))
				.body("name", equalTo("John"))
				.log().all();
	}
	@Test(priority = 2)
	public void addStudent() {
		//List<String> hm=new ArrayList<String>();
		HashMap<String,String> hm=new HashMap<String,String>();
		hm.put("name","John");
		hm.put("location","india");
		hm.put("phone","1234567890");
		hm.put("cources","Java");
		
		id=given()
				.contentType("application/json")
				.body(hm)
		
		.when()
			.post("http://localhost:3000/students")
			.jsonPath().getInt("id");
		
			
	}
	@Test(priority = 3, dependsOnMethods = "addStudent")
	public void upDateStudent() {
		HashMap<String,String> hm=new HashMap<String,String>();
		hm.put("name","Ganesh");
		hm.put("location","USA");
		hm.put("phone","9012345678");
		hm.put("cources","API");
		
		given()
			.contentType("application/json")
			.body(hm)
		.when()
			.put("http://localhost:3000/students"+id)
		.then()
			.statusCode(201)
			.log().all();
	}
	
}
