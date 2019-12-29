package com.opti.shope.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "address" )
public class AddressEntity implements Serializable {
	
	private static final long serialVersionUID = 6409759544615263918L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(length = 30,name = "UU_ADDESS_ID")
	private String addrressId;

	@Column(length = 30, nullable = false)	
	private String houseName;

	@Column(length = 30, nullable = false)
	private String locality;

	@Column(length = 30, nullable = false)
	private String landmark;

	@Column(length = 25, nullable = false)
	private String city;

	@Column(length = 25, nullable = false)
	private String state;

	@Column(length = 25, nullable = false)
	private String country;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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


}
