/**
 * 
 */
package com.day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
/**
 *
 * Path= Before question mark will consider as path
 * Query=Post question mark will consider as query param
 * path param is like variables
 * Query param is not like variable
 */
public class PathAndQueryParam {
	
	//https://reqres.in/api/users?page=2&id=7
	@Test
	public void QuryandPath(){
		given()
		.pathParam("myPath", "users")
		.queryParam("page", 2)
		.queryParam("id", 5)
		.when()
			.get("https://reqres.in/api/{myPath}")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
