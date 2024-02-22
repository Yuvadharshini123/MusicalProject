package com.musical.project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Address {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressGenerator")
	@SequenceGenerator(name = "addressGenerator", sequenceName = "addressSequence", initialValue = 1001, allocationSize = 1)
	@Column(name = "addressID")
	private int addressId;

	
	@Column(name = "pincode", length = 6)
	private long pincode;


	@Column(name = "Dno")
	private String Dno;


	@Column(name = "locality")
	private String locality;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	
	@Column(name = "country")
	private String country;


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public long getPincode() {
		return pincode;
	}


	public void setPincode(long pincode) {
		this.pincode = pincode;
	}


	public String getDno() {
		return Dno;
	}


	public void setDno(String dno) {
		Dno = dno;
	}


	public String getLocality() {
		return locality;
	}


	public void setLocality(String locality) {
		this.locality = locality;
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
  
	
	
}
