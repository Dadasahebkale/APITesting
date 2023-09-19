package com.day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class SerilizationDeserilization {

	//pojo ---> JSON (Serialization)
	@Test(priority = 1)
	public void convert2POJO() throws JsonProcessingException {
		StudentPojo sp=new StudentPojo();
		sp.setName("Vikas");
		sp.setLocation("New Zealand");
		sp.setPhone("979899");
		String courseArr[]= {"Science","Math"};
		sp.setCourses(courseArr);
		
		//convert java object ------> Json object(Serialization)
		ObjectMapper objmapper=new ObjectMapper();
		String jsondata=objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(sp);
		
		System.out.println(jsondata);
	}
	// JSON ----- > POJO (De-serialization)
	@Test(priority = 2)
	public void convertJSON2pojo() throws JsonProcessingException {
		//convert json to pojo
		String jsondata="{\r\n"
				+ "  \"name\" : \"Vikas\",\r\n"
				+ "  \"location\" : \"New Zealand\",\r\n"
				+ "  \"phone\" : \"979899\",\r\n"
				+ "  \"courses\" : [ \"Science\", \"Math\" ]\r\n"
				+ "}";
		//convert json data ---> Pojo data
		ObjectMapper objmapper=new ObjectMapper();
		StudentPojo sp=  objmapper.readValue(jsondata, StudentPojo.class);
		System.out.println("Name :"+sp.getName());
		System.out.println("Location : "+sp.getLocation());
		System.out.println("Phone : "+sp.getPhone());
		System.out.println("Course 1: "+sp.getCourses()[0]);
		System.out.println("Course 2: "+sp.getCourses()[1]);
		
		
				
	}
}
