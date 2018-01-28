package com.sharma.nks.ht.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private int floor;
	@Column(name="housename",length=25)
	private String houseName;
	@Column(length=25)
	private String street;
	@Column(length=15)
	private String block;
	@Column(length=25)
	private String locality;
	@Column(length=25)
	private String city;
	@Column(length=25)
	private String state;
	@Column(length=15)
	private String country;
	
	public Address() {	}
	
	/**
	 * 
	 * @param floor
	 * @param houseName
	 * @param street
	 * @param block
	 * @param locality
	 * @param city
	 * @param state
	 * @param country
	 */
	public Address(int floor, String houseName, String street, String block, String locality, String city,
			String state, String country) {
		this.floor = floor;
		this.houseName = houseName;
		this.street = street;
		this.block = block;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
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

	@Override
	public String toString() {
		return "Address {floor : " + floor + ", houseName : " + houseName + ", street : " + street + ", block : " + block
				+ ", locality : " + locality + ", city : " + city + ", state : " + state + ", country : " + country + "}";
	}
		
}
