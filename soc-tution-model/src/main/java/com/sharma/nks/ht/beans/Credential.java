package com.sharma.nks.ht.beans;

import javax.persistence.*;


@Entity
@Table(name="TABLE_CREDENTIAL")
public class Credential {

	@Id
	private String userId;
	private String password;
	private String role;
	private boolean isLoggedIn;
	
	public Credential(){}
	public Credential(String userId, String password, String role, boolean isLoggedIn) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.isLoggedIn = isLoggedIn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	@Override
	public String toString() {
		return "Credential {userId : " + userId + ", password : " + password + ", role : " + role + ", isLoggedIn : "
				+ isLoggedIn + "}";
	}
	
}
