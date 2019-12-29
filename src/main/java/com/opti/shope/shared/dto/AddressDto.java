package com.opti.shope.shared.dto;

import java.io.Serializable;


public class AddressDto  implements Serializable{
	private static final long serialVersionUID = 2737650696076246530L;
	private long id;
	private String houseName;
	private String locality;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private String addrressId;
	private UserDto userDetails;
	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddrressId() {
		return addrressId;
	}

	public void setAddrressId(String addrressId) {
		this.addrressId = addrressId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDto getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDto userDetails) {
		this.userDetails = userDetails;
	}



}
