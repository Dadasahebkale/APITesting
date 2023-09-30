package com.day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONException;
import org.json.JSONObject;
public class CreateUser {

	@Test
	public void createUserTest(ITestContext context) {
		// this local repo added to github repo
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		try {
			data.put("name", faker.name().fullName());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.put("gender", "Male");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.put("email", faker.internet().emailAddress());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.put("status", "inactive");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//int id=(Integer) context.getSuite().getAttribute("user_id");
		String bearerToken="c02c8f07f231e809e55de627a3689d280ec66535cff354042fd4e0d666e61624";
		
	int id=	given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
		
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		System.out.println("Generated id is "+id);
		context.getSuite().setAttribute("user_id", id);
		
		
		
	}
}
