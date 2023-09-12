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

import java.util.Map;

/**
 * 
 */
public class CaptureSingleHeader {

	@Test(priority = 1)
	public void validateFlipCartHeaders() {

		given()

				.when().get("https://www.flipkart.com/")

				.then().header("server", "nginx").header("content-type", "text/html; charset=utf-8")
				.header("content-encoding", "gzip");
		// .log().all();

	}

	@Test(priority = 2)
	public void getGoogleHeaders() {

		given()

				.when().get("https://www.google.com/").then().header("Content-Encoding", "gzip").header("Server", "gws")
				.header("Content-Type", "text/html; charset=ISO-8859-1");
		// .log().all();
	}
}
