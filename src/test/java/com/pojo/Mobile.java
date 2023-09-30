package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mobile {

	
	private String coursetitle;
	private String price;
	public String getCoursetitle() {
		return coursetitle;
	}
	public void setCoursetitle(String coursetitle) {
		this.coursetitle = coursetitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
}
