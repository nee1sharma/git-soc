package com.sharma.nks.ht.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="TABLE_TUTOR")
public class Tutor {

	@Id
	private String tid;	
	private int experience;
	private int studentsTaught;
	
	@ElementCollection(fetch=FetchType.EAGER) //@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@CollectionTable(name="qualification_set", joinColumns=@JoinColumn(name="tid"))
	private Set<Qualification> qualification=new HashSet<Qualification>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="subjects_set",joinColumns=@JoinColumn(name="tid"))
	private Set<String> subjectsTaught=new HashSet<String>();
	

	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getStudentsTaught() {
		return studentsTaught;
	}
	public void setStudentsTaught(int studentsTaught) {
		this.studentsTaught = studentsTaught;
	}
	public Set<Qualification> getQualification() {
		return qualification;
	}
	public void setQualification(Set<Qualification> qualification) {
		this.qualification = qualification;
	}
	public Set<String> getSubjectsTaught() {
		return subjectsTaught;
	}
	public void setSubjectsTaught(Set<String> subjectsTaught) {
		this.subjectsTaught = subjectsTaught;
	}

	public Tutor(String tid, int experience, int studentsTaught, Set<Qualification> qualification,
			Set<String> subjectsTaught) {
		super();
		this.tid = tid;
		this.experience = experience;
		this.studentsTaught = studentsTaught;
		this.qualification = qualification;
		this.subjectsTaught = subjectsTaught;
	}
	public Tutor(){}

	@Override
	public String toString() {
		return "Tutor {tid : " + tid + ", experience : " + experience + ", studentsTaught : " + studentsTaught
				+ ", qualification : " + qualification + ", subjectsTaught : " + subjectsTaught + "}";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + experience;
		result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
		result = prime * result + studentsTaught;
		result = prime * result + ((subjectsTaught == null) ? 0 : subjectsTaught.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		if (experience != other.experience)
			return false;
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		if (studentsTaught != other.studentsTaught)
			return false;
		if (subjectsTaught == null) {
			if (other.subjectsTaught != null)
				return false;
		} else if (!subjectsTaught.equals(other.subjectsTaught))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		return true;
	}
	
}