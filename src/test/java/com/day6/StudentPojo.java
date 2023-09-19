/**
 * 
 */
package com.day6;

/**Setter method will take one parameter and assign value to class level variable
Getter method get the value from the variable
 * 
 */
public class StudentPojo {

	private String name;
	private String location;
	private String phone;
	private String cources[];
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return cources;
	}
	public void setCourses(String[] courses) {
		this.cources = courses;
	}
	
}
