package com.api.test;

import org.testng.annotations.Test;

import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;
public class Oauth {

	@Test
	public static void getCourseTest() {
		//GetCourse gc=
				given()//.expect().defaultParser(Parser.JSON)
				.when()
				.get("http://localhost:3000/dkcourse")
				.then().log().all();//.as(GetCourse.class);
		//System.out.println(gc.getInstructor());
		
		
	}
}
