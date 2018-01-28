package com.sharma.nks.ht.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.nks.ht.beans.Address;
import com.sharma.nks.ht.beans.Profile;
import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateProfileRequest;
import com.sharma.nks.ht.models.RtrvProfileResponse;
import com.sharma.nks.ht.svc.IProfileService;

@RestController
public class ProfileController {

	private final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	IProfileService psvc;

	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public BaseResponse saveProfile(@RequestBody CreateProfileRequest createProfileRequest){
		logger.debug("Create new profile : "+createProfileRequest);		
		BaseResponse resp=null;
		if(null!=createProfileRequest){
			resp=psvc.createProfile(createProfileRequest);
		}
		return resp;
	}
	
	@RequestMapping(value="/profile/{id}",method=RequestMethod.GET)
	public RtrvProfileResponse getProfileById(@PathVariable("id") String pid){
		logger.info("Get profile by ID : "+pid);
		RtrvProfileResponse resp=null;
		if(null!=pid){
			resp=psvc.viewProfileById(pid);
		}
		return resp;
		
	}
	
	@RequestMapping(value="/profiles",method=RequestMethod.GET)
	public RtrvProfileResponse getAllProfiles(@RequestParam(name="offset",required=false,defaultValue="0") int offset){
		logger.info("Get all profiles with offset : "+offset);
		RtrvProfileResponse resp=psvc.viewAllProfiles(offset);
		return resp;

	}
	
	
	
	
	
	
	
	/************************************************************************************/ 
	
	@RequestMapping(value="/profilestub",method=RequestMethod.GET)
	public CreateProfileRequest getStubbedTutor(){
		logger.info("Get profile stub called.");
		Address addr=new Address(1,"Sharma House","street num 5","BE","Hari nagar","New Delhi","Delhi","IN");
		Profile p1=new Profile("ne1001","NKS stud","20-04-1992","10-09-2013","","M","7896541230","nks@stud.com",Profile.Role.STUDENT,addr);
		CreateProfileRequest req=new CreateProfileRequest();
		req.setProfile(p1);
		return req;
	}
}
