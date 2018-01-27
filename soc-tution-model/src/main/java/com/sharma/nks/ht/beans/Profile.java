package com.sharma.nks.ht.beans;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TABLE_PROFILE")
public class Profile {
	
	@Id
	private String userId;
	private String name;
	private Date DOB;
	private Date DOJ;
	private Date lastActive;
	private String gender;
	private String phone;
	private String email;
	private String role;
	//@JoinColumn(name="id")
	@OneToOne(fetch=FetchType.EAGER)
	private Address address;
	
	public Profile() {	}
	
	public Profile(String userId,String name, Date dOB, Date dOJ, Date lastActive, String gender, String phone, String email, String role,
			Address address) {
		this.userId=userId;
		this.name = name;
		DOB = dOB;
		DOJ = dOJ;
		this.lastActive=lastActive;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.address = address;
	}


	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getDOJ() {
		return DOJ;
	}
	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}
	public Date getLastActive() {
		return lastActive;
	}
	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Profile {userId : " + userId + ", name : " + name + ", DOB : " + DOB + ", DOJ : " + DOJ + ", lastActive : "
				+ lastActive + ", gender : " + gender + ", phone : " + phone + ", email : " + email + ", role : " + role
				+ ", address : " + address + "}";
	}
	
	
}