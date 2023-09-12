
package com.day2;


/**Setter method will take one parameter and assign value to class level variable
Getter method get the value from the variable
 * 
 */
public class POJOTester {

	String name;
	String location;
	String Phone;
	String Testings[];
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
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String[] getTestings() {
		return Testings;
	}
	public void setTestings(String[] testings) {
		Testings = testings;
	}
	
}
