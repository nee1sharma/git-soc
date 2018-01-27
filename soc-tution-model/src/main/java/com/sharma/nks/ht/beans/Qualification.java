package com.sharma.nks.ht.beans;

import javax.persistence.*;

/**
 * 
 * @author Heavens<br/> 
 * @since: Jun 30, 2017
 * stream : BCA, BBA, MBA, CA
 * college : IITM, IIT
 */
//@Entity
//@Table(name="Qualification_SET")
@Embeddable
public class Qualification {

	//@Id
	private String qid;
	private int overAllPercentage;
	private String passoutYear;
	private String stream;
	private String college;
	private String university;
	
	public Qualification(){}
	
	public Qualification(String university, String college, String stream, String passoutYear, int overAllPercentage) {
		this.university = university;
		this.college = college;
		this.stream = stream;
		this.passoutYear = passoutYear;
		this.overAllPercentage = overAllPercentage;
	}

	public int getOverAllPercentage() {
		return overAllPercentage;
	}
	public void setOverAllPercentage(int overAllPercentage) {
		this.overAllPercentage = overAllPercentage;
	}
	public String getPassoutYear() {
		return passoutYear;
	}
	public void setPassoutYear(String passoutYear) {
		this.passoutYear = passoutYear;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}

	@Override
	public String toString() {
		return "Qualification {university : " + university + ", college : " + college + ", stream : " + stream
				+ ", passoutYear : " + passoutYear + ", overAllPercentage : " + overAllPercentage + "}";
	}
}
