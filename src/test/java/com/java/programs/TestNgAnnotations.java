package com.java.programs;

import java.time.Duration;

import org.checkerframework.checker.signature.qual.ClassGetName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {
public static WebDriver driver;
public static ChromeOptions ops;
public static String url="https://www.google.com";
@BeforeSuite
public void beforeSuiteTest() {

	//driver.get("https://www.google.com");
	System.out.println("I'm using beforeSuite Annotation");
}
@BeforeTest
public void beforeTest() {

	System.out.println("I'm using beforeTest Annotation");
}
@BeforeClass
public void beforeClassTest() {
	System.out.println("I'm using beforeClass Annotation");
}
@BeforeMethod
public void beforeMethodTest() {
	ops=new ChromeOptions();
	ops.setBrowserVersion("116");
	driver=new ChromeDriver(ops);
	driver.manage().window().maximize();
	driver.get(url);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	System.out.println("user navigate to "+url+" on the chrome browser");
	System.out.println("I'm using beforeMethod Annotation");
}
@Test(priority = 1)
public void testMethod() {
	System.out.println(driver.getTitle());
	System.out.println("Im in actual test method Annotation and using priority helper attribute");
}

@AfterMethod
public void afterMethod() {
	driver.quit();
	System.out.println("Browser has been closed");
	System.out.println("I'm in the aftermethod Annotation");
	System.out.println("============================================");
}
@AfterClass
public void afterClassTest() {
	System.out.println("I'm in the after class method Annotation");
}
@AfterTest
public void afterTest() {
	System.out.println("I'm in the after method test Annotation");
}
@AfterSuite
public void afterSuite() {
	
	System.out.println("I'm in the after suite method Annotation");
}
@Test(priority = 2, invocationCount = 3)
public void testMethod2() {
	System.out.println(driver.getCurrentUrl()+" Second method");
	System.out.println("Im in actual test method-2 Annotation and using priority helper attribute");
}
	
}
