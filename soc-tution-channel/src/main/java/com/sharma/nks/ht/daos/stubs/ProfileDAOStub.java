package com.sharma.nks.ht.daos.stubs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sharma.nks.ht.beans.Address;
import com.sharma.nks.ht.beans.Profile;
import com.sharma.nks.ht.daos.IProfileDAO;
import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateProfileRequest;
import com.sharma.nks.ht.models.RtrvProfileResponse;

@Repository(value="profileStub")
public class ProfileDAOStub implements IProfileDAO {

	private List<Profile> profiles;
	public ProfileDAOStub(){
		profiles=new ArrayList<Profile>();
		Address addr=new Address(1,"Sharma House","street num 5","BE","Hari nagar","New Delhi","Delhi","IN");
		Profile p1=new Profile("ne1001","NKS stud",new Date(),new Date(),new Date(),"M","7896541230","nks@stud.com","studnet",addr);
		profiles.add(p1);
	}
	
	public BaseResponse createProfile(CreateProfileRequest createProfileRequest) {
		if(null!=createProfileRequest.getProfile()){
			profiles.add(createProfileRequest.getProfile());
		}
		BaseResponse resp=new BaseResponse();
		resp.setResponseCode("000");
		return resp;
	}

	public RtrvProfileResponse viewAllProfiles() {
		RtrvProfileResponse resp=new RtrvProfileResponse();
		resp.setProfiles(profiles);
		resp.setResponseCode("000");
		return resp;
	}

	public RtrvProfileResponse viewProfileById(String pid) {
		RtrvProfileResponse resp=new RtrvProfileResponse();

		resp.setProfiles(profiles.stream()
		.filter(profile -> profile.getUserId().equals(pid))
		.collect(Collectors.toList()));
		
		
		return resp;
	}
}
