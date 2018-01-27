package com.sharma.nks.ht.controllers;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		logger.debug("In ProfileController.");		
		BaseResponse resp=null;
		if(null!=createProfileRequest){
			resp=psvc.createProfile(createProfileRequest);
		}
		return resp;
	}
	
	@RequestMapping(value="/profile/{id}",method=RequestMethod.GET)
	public RtrvProfileResponse getProfileById(@PathVariable("id") String pid){
		
		RtrvProfileResponse resp=null;
		if(null!=pid){
			resp=psvc.viewProfileById(pid);
		}
		return resp;
		
	}
	
	@RequestMapping(value="/profiles",method=RequestMethod.GET)
	public RtrvProfileResponse getAllProfiles(){
		RtrvProfileResponse resp=psvc.viewAllProfiles();
		return resp;

	}
	
	
	
	
	
	
	
	/************************************************************************************/ 
	
	@RequestMapping(value="/profilestub",method=RequestMethod.GET)
	public CreateProfileRequest getStubbedTutor(){
		Address addr=new Address(1,"Sharma House","street num 5","BE","Hari nagar","New Delhi","Delhi","IN");
		Profile p1=new Profile("ne1001","NKS stud",new Date(),new Date(),new Date(),"M","7896541230","nks@stud.com","studnet",addr);
		CreateProfileRequest req=new CreateProfileRequest();
		req.setProfile(p1);
		return req;
	}
}
