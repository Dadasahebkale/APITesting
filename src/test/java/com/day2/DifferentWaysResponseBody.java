/**
 * 
 */
package com.day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Hashtable;

import org.testng.annotations.Test;
/**
 Different ways to create POST request body
 	1.Post request body using hashmap
 	2.Post request body creation using org.json body
 	3.Post request body creation using POJO class=> Plain old java obhect
 	4.Post request body using exeternal JSON file data
 
 * 
 */
public class DifferentWaysResponseBody {
	int id;
	@Test(priority = 1)
	public void addStudent() {
		
		HashMap<String,Object> hm=new HashMap<String, Object>();
		hm.put("name", "Oviya");
		hm.put("location", "india");
		hm.put("phone", "1234567890");
		
		String courseArr[]= {"API","JMeter"};
		hm.put("cources", courseArr);
		
		id=given()
				.contentType("application/json")
				.body(hm)
		
		.when()
			.post("http://localhost:3000/students")
		
			.jsonPath().getInt("id");
		given().when()
		.then()
			.statusCode(201)
			.body("name", equalTo("Oviya"))
			.body("location", equalTo("india"))
			.body("phone", equalTo("1234567890"))
			.body("cources[0]",equalTo("API"))
			.body("cources[1]",equalTo("JMeter"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		
			
	}
	//@Test(priority=2)
	public void getStudent() {
		given()
		
		.when()
			.get("http://localhost:3000/students/"+id)
			//.jsonPath().getInt("id");
		.then().statusCode(200)
		.log().all();
		
	}
	@Test(priority = 3)
	public void DeleteStudent() {
		
		given()
		
		.when()
		.delete("http://localhost:3000/students/"+id)
		.then()
			.statusCode(200);
			//.log().all();
	}
}
