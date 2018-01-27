package com.sharma.nks.ht.models;

import java.util.ArrayList;
import java.util.List;
import com.sharma.nks.ht.beans.Tutor;

public class TutorSearchResponse extends BaseResponse{
		
	private List<Tutor> tutorList;

	public List<Tutor> getTutorList() {
		if(null==tutorList){
			tutorList=new ArrayList<Tutor>();
		}
		return tutorList;
	}

	public void setTutorList(List<Tutor> tutorList) {
		this.tutorList = tutorList;
	}
}
