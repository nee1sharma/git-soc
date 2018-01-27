package com.sharma.nks.ht.models;

import com.sharma.nks.ht.beans.Tutor;

/**
 * This class contains Tutor object
 * @author Heavens<br/> 
 * @since: Aug 26, 2017<br/>
 * @version 0.0.0.1
 */
public class CreateTutorRequest extends BaseRequest{

	private Tutor tutor;
	
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	@Override
	public String toString() {
		return "CreateTutorRequest {tutor : " + tutor + "}";
	}
	
}
