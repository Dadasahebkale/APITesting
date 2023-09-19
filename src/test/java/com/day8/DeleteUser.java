package com.day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
public class DeleteUser {

	@Test
	public void deletUser(ITestContext context) {
		
		int id=(Integer) context.getSuite().getAttribute("user_id");
		String bearerToken="c02c8f07f231e809e55de627a3689d280ec66535cff354042fd4e0d666e61624";
		
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.pathParam("id", id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204);
		
		
		
		
	}
}
