package com.sharma.nks.ht.beans;

import javax.persistence.*;

/**
 * 
 * @author Heavens<br/> 
 * @since: Jun 30, 2017
 * stream : BCA, BBA, MBA, CA
 * college : IITM, IIT
 */

@Embeddable
public class Qualification {

	private String qid;
	@Column(name="percentage", length=2)
	private int overAllPercentage;
	@Column(name="passoutyear", length=4)
	private String passoutYear;
	@Column(name="majorstream", length=20)
	private String stream;
	@Column(length=50)
	private String college;
	@Column(length=50)
	private String university;
	
	public Qualification(){}
	
	/**
	 * 
	 * @param university
	 * @param college
	 * @param stream
	 * @param passoutYear
	 * @param overAllPercentage
	 */
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
