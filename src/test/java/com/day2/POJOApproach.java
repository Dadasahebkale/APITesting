/**
 * 
 */
package com.day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

/**
 * given is used for content-type, add cookies, set auth, add param, set headers etc...
 * when use adding https request for get, put,post,delete..
 * then use for validation, like status code,extract response, extract header,cookies and response
 * 
 * 
 
 post response body using org.json
 */
public class POJOApproach {
	int id;
	@Test(priority=1)
	public void PojoTest() {
		POJO_PostRequest data=new POJO_PostRequest();
		data.setName("Scott");
		data.setLocation("England");
		data.setPhone("9876543212");

		String courseArr[]= {"API","JMeter"};
		data.setCourses(courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students").jsonPath().getInt("id");
		given().when()
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location", equalTo("England"))
			.body("phone", equalTo("9876543212"))
			.body("cources[0]", equalTo("API"))
			.body("courses[1]", equalTo("JMeter"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	@Test(priority = 2)
	public void DeleteStudent() {
       
		given().when()
			//.delete("http://localhost:3000/students/"+id)
			.delete("http://localhost:3000/students/4")
			
		.then()
			.statusCode(200)
			.log().all();
	}

}
