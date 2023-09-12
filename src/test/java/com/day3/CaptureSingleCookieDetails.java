/**
 * 
 */
package com.day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
/**
 * 
 */
public class CaptureSingleCookieDetails {

	@Test
	public void getGoogleCookies() {
		
		Response res=given()

		.when()
			.get("https://www.google.com/");
		String cookievalue=res.getCookie("AEC");
		//getting single cookie info
		
		System.out.println("Value of cookie is =====>"+cookievalue);
		
	}
}
