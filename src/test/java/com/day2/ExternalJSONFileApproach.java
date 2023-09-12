/**
 * 
 */
package com.day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
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
public class ExternalJSONFileApproach {
	int id;
	@Test(priority=1)
	public void ExternalJsonTest() throws FileNotFoundException {
		File file=new File(".\\body.json");
				//"D:\\CucumberLatest\\RestAssured\\body.json");
		FileReader filereader=new FileReader(file);
		JSONTokener jsontokener=new JSONTokener(filereader);
		JSONObject data=new JSONObject(jsontokener);
		
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
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
			.delete("http://localhost:3000/students/3")
			
		.then()
			.statusCode(200)
			.log().all();
	}

}
