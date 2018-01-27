package com.sharma.nks.ht.models;

import java.util.Set;

import com.sharma.nks.ht.beans.Address;

public class TutorSearchRequest {
	
	private int experience;
	private Set<String> subjectsTaught;
	private int studentsTaught;
	private Address address;
	 
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Set<String> getSubjectsTaught() {
		return subjectsTaught;
	}
	public void setSubjectsTaught(Set<String> subjectsTaught) {
		this.subjectsTaught = subjectsTaught;
	}
	public int getStudentsTaught() {
		return studentsTaught;
	}
	public void setStudentsTaught(int studentsTaught) {
		this.studentsTaught = studentsTaught;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
