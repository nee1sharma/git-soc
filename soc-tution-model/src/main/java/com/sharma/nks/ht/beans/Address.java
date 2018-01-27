package com.sharma.nks.ht.beans;

import javax.persistence.*;

@Entity
@Table(name="TABLE_ADDRESS")
public class Address {
	@Id
	@GeneratedValue
	private int id;
	private int floor;
	private String houseName;
	private String street;
	private String block;
	private String locality;
	private String city;
	private String state;
	private String country;
	
	public Address() {	}
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Address {floor : " + floor + ", houseName : " + houseName + ", street : " + street + ", block : " + block
				+ ", locality : " + locality + ", city : " + city + ", state : " + state + ", country : " + country + "}";
	}
		
}
