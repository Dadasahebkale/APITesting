package com.day7;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
public class TestBasicAuthentication {
	
	@Test(priority = 1,enabled = false)
	public void basicAuthentication() {
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
			//https://postman-echo.com/basic-auth
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	@Test(priority = 2,enabled = false)
	public void digestAuthentication() {
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
			//https://postman-echo.com/basic-auth
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	@Test(priority =3,enabled = false)
	public void preemptiveAuthentication() {
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
			//https://postman-echo.com/basic-auth
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	@Test(priority =4,enabled = false)
	public void bearerTokenAuthentication() {
		String beartoken="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";
		given()
			.headers("Authorization","Bearer "+beartoken)
			.when()
			.get("https://api.github.com/user/repos")
			
			//https://postman-echo.com/basic-auth
		.then()
			.statusCode(200);
			//.body("authenticated", equalTo(true))
			//.log().all();
	}
	@Test(priority = 5, enabled = false)
	public void auth2Authentication() {
		String accestoken="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";
		given()
			.auth().oauth2(accestoken)
		.when()
			.get("https://api.github.com/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
	}	
	@Test(priority = 6)
	public void apiKeyAuthentication() {
		//1st approach
//		given()
//			.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
//		.when()
//			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Pune&units=metrics&cnt=7")
//		.then()
//			.statusCode(200)
//			.log().all();
//		
//	}
	//2 approach
		String queryparameter="fe9c5cddb7e01d747b4611c3fc9eaf2c";
	given()
		.queryParam("appid", queryparameter)
		.pathParam("mypath", "data/2.5/forecast/daily")
		.queryParam("q", "Pune")
		.queryParam("units", "metrics")
		.queryParam("cnt", "7")
	.when()
	.get("https://api.openweathermap.org/{mypath}")
	.then()
	.statusCode(200)
	.log()
	.all();
}
}
