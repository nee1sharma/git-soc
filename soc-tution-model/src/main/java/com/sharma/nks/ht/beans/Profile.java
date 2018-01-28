package com.sharma.nks.ht.beans;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TABLE_PROFILE")
public class Profile {
	
	public enum Role{
		TUTOR(0),
		STUDENT(1),
		ADMIN(2);
		
		private int value;
		public int getValue() {
			return value;
		}
		
		Role(int id) {	value=id;}
		public static Role parse(int id){
			Role role=null;
			for(Role r:Role.values()){
				if(r.getValue()==id){
					role=r;
				}
			}
			return role;
		}
	}
	@Id
	@Column(length=10)
	private String userId;
	@Column(length=25)
	private String name;
	@Column(length=10)
	private String DOB;
	@Column(length=10)
	private String DOJ;
	@Column(length=25)
	private String lastActive;
	@Column(length=1)
	private String gender;
	@Column(length=12)
	private String phone;
	@Column(length=25)
	private String email;
	private Role role;

	@Embedded
	private Address address;
	
	public Profile() {	}
	
	/**
	 * 
	 * @param userId
	 * @param name
	 * @param dOB
	 * @param dOJ
	 * @param lastActive
	 * @param gender
	 * @param phone
	 * @param email
	 * @param role
	 * @param address
	 */
	public Profile(String userId,String name, String dOB, String dOJ, String lastActive, String gender, String phone, String email, Role role,
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
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public String getLastActive() {
		return lastActive;
	}
	public void setLastActive(String lastActive) {
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
		return "Profile {userId : " + userId + ", name : " + name + ", DOB : " + DOB + ", DOJ : " + DOJ
				+ ", lastActive : " + lastActive + ", gender : " + gender + ", phone : " + phone + ", email : " + email
				+ ", role : " + role + ", address : " + address + "}";
	}

}