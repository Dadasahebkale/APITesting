package com.pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

public class OauthTest extends GetCourse {
public static WebDriver driver;
//Test(priority = 0)
public void getCourseTest() throws InterruptedException {
	ChromeOptions ops=new ChromeOptions();
	ops.setBrowserVersion("116");
	driver=new ChromeDriver(ops);
	driver.get("http://localhost:3000/dkcourse");
	Thread.sleep(4000);
	driver.quit();
	
}
@Test(priority = 1)
public void getCourse() {
	given()
	.when()
	.get("http://localhost:3000/dkcourse")
	.then()
	.log().all();
	
}
@Test(priority = 2)
public void course() {
	GetCourse gc=
	given().expect().defaultParser(Parser.JSON)
	.when()
	.get("http://localhost:3000/dkcourse").as(GetCourse.class);
	System.out.println(gc.getInstructor());
		System.out.println(gc.getLinkedIn());
		//System.out.println(gc.getCourses().getApi().get(1).getCoursetitle());
		List<WebAutomation> webautomation=gc.getCourses().getWebautomation();
		for(int i=0;i<webautomation.size();i++) {
//			if(webautomation.get(i).getCoursetitle().equalsIgnoreCase("Java")) {
			
			String text=	webautomation.get(i).getCoursetitle();
			System.out.println(text);
			}
		

}
}
