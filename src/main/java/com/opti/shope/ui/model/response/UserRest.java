package com.opti.shope.ui.model.response;


public class UserRest {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private AddressRest address;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AddressRest getAddress() {
		return address;
	}
	public void setAddress(AddressRest address) {
		this.address = address;
	}	
}
