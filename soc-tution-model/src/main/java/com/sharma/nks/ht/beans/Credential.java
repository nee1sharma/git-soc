package com.sharma.nks.ht.beans;

import javax.persistence.*;


@Entity
@Table(name="TABLE_CREDENTIAL")
public class Credential {

	@Id
	private String userId;
	private String password;
	private boolean isLoggedIn;
	
	public Credential(){}
	public Credential(String userId, String password, boolean isLoggedIn) {
		super();
		this.userId = userId;
		this.password = password;
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
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credential other = (Credential) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equalsIgnoreCase(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Credential {userId : " + userId + ", password : " + password + ", isLoggedIn : "
				+ isLoggedIn + "}";
	}
	
}
