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
public class AllCookieInfo {

	@Test
	public void getGoogleCookies() {
		
		Response res=given()

		.when()
			.get("https://www.google.com/");
		//String cookievalue=res.getCookie("AEC");
		//getting single cookie info
		
		Map<String,String> allcookies=res.getCookies();
		for(String cookies: allcookies.keySet())
		{
			String cookievalue=res.getCookie(cookies);
			System.out.println("Google Cookie name is =>"+cookies+" Value of cookie is =====>"+cookievalue);
		}
		
		
	}
	@Test
	public void getflipkartCookies() {
		
		Response res=given()

		.when()
			.get("https://www.flipkart.com/");
	
		
		Map<String,String> allcookies=res.getCookies();
		for(String cookies: allcookies.keySet())
		{
			String cookievalue=res.getCookie(cookies);
			System.out.println("flipkart Cookie name is =>"+cookies+" Value of cookie is =====>"+cookievalue);
		}		
	}
}
