package com.sharma.nks.ht.svc;

import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateTutorRequest;
import com.sharma.nks.ht.models.TutorSearchRequest;
import com.sharma.nks.ht.models.TutorSearchResponse;

public interface ITutorService {

	/**
	 * 
	 * @param createTutorRequest
	 * @return responseCode 000: successful creation
	 */
	public BaseResponse createTutor(CreateTutorRequest createTutorRequest);

	/**
	 * List of all Tutors
	 * @return List of Tutors
	 */
	public TutorSearchResponse viewAllTutors(int offset);
	
	
	/**
	 * View Tutor by id
	 * @param tid
	 * @return
	 */
	public TutorSearchResponse viewTutorById(String tid);
	
	/**
	 * Search tutor with given search condition
	 * @param tutorSearchRequest
	 * @return
	 */
	public TutorSearchResponse findTutorByInclusiveCriteria(TutorSearchRequest tutorSearchRequest);
	
}
