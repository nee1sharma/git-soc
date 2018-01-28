package com.sharma.nks.ht.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sharma.nks.ht.daos.IProfileDAO;
import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateProfileRequest;
import com.sharma.nks.ht.models.RtrvProfileResponse;

@Service
public class ProfileService implements IProfileService {

	@Autowired @Qualifier("profileDB") //profileDB  or profileStub
	IProfileDAO pdao;
	
	@Override
	public BaseResponse createProfile(CreateProfileRequest createProfileRequest) {
		// TODO Auto-generated
		
		return pdao.createProfile(createProfileRequest);
	}

	@Override
	public RtrvProfileResponse viewAllProfiles(int offset) {
		// TODO Auto-generated method stub
		return pdao.viewAllProfiles(offset);
	}

	@Override
	public RtrvProfileResponse viewProfileById(String pid) {
		// TODO Auto-generated method stub
		return pdao.viewProfileById(pid);
	}

}
