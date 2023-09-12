package com.day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingResponseData {
	
	@Test(priority=0)
	public void simpleApproach() {
		given()
		.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("book[4].title", equalTo("Expand your horizon"));
			
	}
	@Test(priority = 1)
	public void ParsingResonseSearchBookTitle() {

		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

		JSONObject jo = new JSONObject(res.asString());
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
		}
	}

	@Test(priority = 2)
	public void searchForTitleOfBookTest() {
		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

		JSONObject jo = new JSONObject(res.asString());
		// another approach
		boolean status = false;

		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();

			if (bookTitle.equals("Expand your horizon")) {
				status = true;
				break;
			}
		}

		Assert.assertEquals(status, true);

	}

	@Test(priority = 3)
	public void totalPrizeOfBooks() {
		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

		JSONObject jo = new JSONObject(res.asString());
		double totalBookPrice=0; //2203.5;
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String bookPrice = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalBookPrice=totalBookPrice+Double.parseDouble(bookPrice);
	}
		System.out.println("Total price of books "+totalBookPrice);
		Assert.assertEquals(totalBookPrice, 2203.5);
}
}