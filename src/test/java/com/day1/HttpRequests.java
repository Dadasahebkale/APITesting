package com.day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

/**
 * Given()
 * content type, set cookies, add auth, add param, set headers info etc..
 * 
 * when()
 *  we are adding request types=> get,put,post,delete
 *  then()
 *  All validation-Status code, extract response, extract headers cookies, & response body
 */
public class HttpRequests {

	int id;
	@Test(priority = 1)
	public void getUsers() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	@Test(priority = 2)
	public void createUser() {
		HashMap<String,String> hm=new HashMap<String,String>();
		
		hm.put("name", "Ganesh");
		hm.put("school", "DPES");
		id=given()
			.contentType("application/json")  
			.body(hm)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	@Test(priority = 3, dependsOnMethods = "createUser")
	public void UpdateUser() {
		HashMap<String,String> hm=new HashMap<String,String>();
		hm.put("name","Oviya");
		hm.put("school", "Rahul");
		
		given()
				.contentType("application/json")
					.body(hm)
				.when()
					.put("https://reqres.in/api/users/"+id)
				.then()
					.statusCode(200)
					.log().all();
					
	}
	@Test(priority=4)
	public void DeleteUser() {
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}
}

