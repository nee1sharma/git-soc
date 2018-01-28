package com.sharma.nks.ht.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.nks.ht.beans.Qualification;
import com.sharma.nks.ht.beans.Tutor;
import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateTutorRequest;
import com.sharma.nks.ht.models.TutorSearchRequest;
import com.sharma.nks.ht.models.TutorSearchResponse;
import com.sharma.nks.ht.svc.ITutorService;

@RestController
public class TutorController {

	private final Logger logger=Logger.getLogger(getClass());
	
	@Autowired 
	ITutorService tsvc;

	@RequestMapping(value="/tutor", method=RequestMethod.POST)
	public BaseResponse saveTutor(@RequestBody CreateTutorRequest createTutorRequest){
		logger.info("Create tutor : "+createTutorRequest);		
		BaseResponse resp=null;
		if(null!=createTutorRequest){
			resp=tsvc.createTutor(createTutorRequest);
		}
		return resp;
	}
	
	@RequestMapping(value="/tutor/{id}",method=RequestMethod.GET)
	public TutorSearchResponse getTutorById(@PathVariable("id") String tid){
		logger.info("Get tutor by id : "+tid);
		TutorSearchResponse resp=null;
		if(null!=tid){
			resp=tsvc.viewTutorById(tid);
		}
		return resp;
	}

	
	@RequestMapping(value="/tutors",method=RequestMethod.GET)
	public BaseResponse getAllTutors(@RequestParam(name="offset",required=false,defaultValue="0") int offset){
		logger.info("Get all tutors by offset : "+offset);
		BaseResponse resp=tsvc.viewAllTutors(offset);
		return resp;
	}
	
	@RequestMapping(value="/findtutor",method=RequestMethod.GET)
	public TutorSearchResponse findTutorsByCriteria(@RequestParam(name="offset",required=false,defaultValue="0") int offset,
			@RequestBody TutorSearchRequest tutorSearchRequest){
	
		logger.info("Find tutors with search condition : "+tutorSearchRequest);
		
		TutorSearchResponse resp=tsvc.findTutorByInclusiveCriteria(tutorSearchRequest);
		
		return resp;
	}

	
	
	
	
	
	
	/************************************************************************************/ 
	
	@RequestMapping(value="/tutorstub",method=RequestMethod.GET)
	public CreateTutorRequest getStubbedTutor(){
		
		CreateTutorRequest req1=new CreateTutorRequest();
		Qualification q=new Qualification("GGSIPU","IINTM","BCA","2013",72);
		Set<Qualification> qlist=new HashSet<Qualification>();
		qlist.add(q);
		Tutor tutor=new Tutor("T00001",4,2,qlist,new HashSet<String>(Arrays.asList("Maths","Computer")));
		req1.setTutor(tutor);
		return req1;
	}
	
	@RequestMapping(value="/tutorstub", method=RequestMethod.POST)
	public void saveTutor(@RequestBody Tutor t){
		logger.debug("In TutorController.");		
	}
	
}