package com.api.test;

public class Mobile {
	private String courseTitle;
	private String price;
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Mobile [courseTitle=" + courseTitle + ", price=" + price + "]";
	}
	
}
