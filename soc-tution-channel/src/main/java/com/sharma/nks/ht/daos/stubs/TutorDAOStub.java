package com.sharma.nks.ht.daos.stubs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sharma.nks.ht.beans.Qualification;
import com.sharma.nks.ht.beans.Tutor;
import com.sharma.nks.ht.daos.ITutorDAO;
import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateTutorRequest;
import com.sharma.nks.ht.models.TutorSearchRequest;
import com.sharma.nks.ht.models.TutorSearchResponse;

@Repository("tutorStub")
public class TutorDAOStub implements ITutorDAO{
	private Logger LOGGER = Logger.getLogger("dao");

	private List<Tutor> tutors;
	
	public TutorDAOStub() {
		tutors=new ArrayList<Tutor>();
		Qualification q=new Qualification("GGSIPU","IINTM","BCA","2013",72);
		Set<Qualification> qlist=new HashSet<Qualification>();
		qlist.add(q);
		Tutor t1=new Tutor("T00001",4,2,qlist,new HashSet<String>(Arrays.asList("Maths","Computer")));
		
		Qualification q2=new Qualification("IGNOU","MLN","MCA","2014",74);
		qlist.add(q2);
		Tutor t2=new Tutor("T00001",4,2,qlist,new HashSet<String>(Arrays.asList("Science","Computer")));

		tutors.add(t1);
		tutors.add(t2);

	}
	
	public TutorSearchResponse viewAllTutors(int offset) {
		TutorSearchResponse resp= new TutorSearchResponse();
		
		resp.setTutorList(tutors);
		resp.setResponseCode("000");
		
		return resp;
	}

	public TutorSearchResponse viewTutorById(String tid) {
		TutorSearchResponse resp=new TutorSearchResponse();

		resp.setTutorList(
				tutors.stream()
				.filter(tutor -> tutor.getTid().equals(tid))
				.collect(Collectors.toList())
				);
		
		resp.setResponseCode("000");	
		return resp;
	}

	public BaseResponse createTutor(CreateTutorRequest createTutorRequest) {
		if(null!=createTutorRequest.getTutor()){
			tutors.add(createTutorRequest.getTutor());
		}
		BaseResponse resp=new BaseResponse();
		resp.setResponseCode("000");

		return resp;
	}

	public TutorSearchResponse findTutorByInclusiveCriteria(TutorSearchRequest tutorSearchRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
