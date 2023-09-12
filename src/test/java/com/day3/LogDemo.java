package com.day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class LogDemo {

	@Test
	public void GetLogDetails() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2&id=7")
		.then()
//			.log().cookies()
//			.log().headers()
			.log().body();
			
	}
}
