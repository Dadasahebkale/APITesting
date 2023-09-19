package com.day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;



public class GenerateDummyData {

	@Test
	public void dummyData() {
		Faker faker=new Faker();
		
		String fullName=faker.name().fullName();
		String FirstName=faker.name().firstName();
		String LastName=faker.name().lastName();
		String username=faker.name().username();
		String password=faker.internet().password();
		String phone=faker.phoneNumber().cellPhone();
		String email=faker.internet().emailAddress();
		String nationality=faker.nation().nationality();
		String countryName=faker.nation().capitalCity();
		
		System.out.println("Full name is "+fullName);
		System.out.println("First name is "+FirstName);
		System.out.println("Last name is "+LastName);
		System.out.println("User name is "+username);
		System.out.println("Password is "+password);
		System.out.println("Phone number is "+phone);
		System.out.println("Email address is "+email);
		System.out.println("Nationality is "+nationality);
		System.out.println("City address is "+countryName);
	}
}
