/**
 * 
 */
package com.day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

/**
 * 
 */
public class HeadersValidation {

	@Test(priority = 1)
	public void validateFlipCartHeaders() {

		Response res = given()

				.when().get("https://www.flipkart.com/");

		// get single headers info
		System.out.println(res.getHeader("content-type"));

	}

	@Test(priority = 2)
	public void CaptureMultipleGoogleHeaders() {

		Response res = given()

				.when().get("https://www.google.com/");
		Headers myHeaders = res.getHeaders();
		for (Header hd : myHeaders.asList()) {
			System.out.println("Name of header :" + hd.getName() + "   " + hd.getValue());
		}

	}
}
