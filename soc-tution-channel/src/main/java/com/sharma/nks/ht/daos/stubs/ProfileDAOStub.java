package com.sharma.nks.ht.daos.stubs;

import java.util.ArrayList;
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
		Address addr1=new Address(1,"Sharma House","street num 5","BE","Hari nagar","New Delhi","Delhi","IN");
		Profile p1=new Profile("ne3001","NKS stud","20-04-1992","10-09-2013","","M","7896541230","nks@stud.com",Profile.Role.STUDENT,addr1);
		
		Address addr2=new Address(1,"Gera House","1","A","Subhash nagar","New Delhi","Delhi","IN");
		Profile p2=new Profile("ge2002","Gera tut","15-04-1992","10-09-2013","","F","7812141230","gera@tut.com",Profile.Role.TUTOR,addr2);
		
		profiles.add(p1);
		profiles.add(p2);
	}
	
	public BaseResponse createProfile(CreateProfileRequest createProfileRequest) {
		if(null!=createProfileRequest.getProfile()){
			profiles.add(createProfileRequest.getProfile());
		}
		BaseResponse resp=new BaseResponse();
		resp.setResponseCode("000");
		return resp;
	}

	public RtrvProfileResponse viewAllProfiles(int offset) {
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
