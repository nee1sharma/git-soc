package com.sharma.nks.ht.models;

import java.util.ArrayList;
import java.util.List;

import com.sharma.nks.ht.beans.Profile;

public class RtrvProfileResponse extends BaseResponse{
	private List<Profile> profiles;

	public List<Profile> getProfiles() {
		if(null==profiles)
			profiles=new ArrayList<Profile>();
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	
}