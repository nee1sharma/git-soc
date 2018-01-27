package com.sharma.nks.ht.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sharma.nks.ht.daos.ITutorDAO;
import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateTutorRequest;
import com.sharma.nks.ht.models.TutorSearchRequest;
import com.sharma.nks.ht.models.TutorSearchResponse;

@Service
public class TutorService implements ITutorService {

	@Autowired
	@Qualifier("tutorDB") //tutorDB  or tutorStub
	ITutorDAO tdao;
	
	@Override
	public BaseResponse createTutor(CreateTutorRequest createTutorRequest) {
		// TODO Auto-generated method stub
		return tdao.createTutor(createTutorRequest);
	}

	@Override
	public TutorSearchResponse viewAllTutors() {
		// TODO Auto-generated method stub
		return tdao.viewAllTutors();
	}

	@Override
	public TutorSearchResponse viewTutorById(String tid) {
		// TODO Auto-generated method stub
		return tdao.viewTutorById(tid);
	}

	@Override
	public TutorSearchResponse findTutorByInclusiveCriteria(TutorSearchRequest tutorSearchRequest) {
		// TODO Auto-generated method stub
		return tdao.findTutorByInclusiveCriteria(tutorSearchRequest);
	}

}
