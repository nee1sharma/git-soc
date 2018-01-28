package com.sharma.nks.ht.models;

import com.sharma.nks.ht.beans.Profile;

public class CreateProfileRequest {
	private Profile profile;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "CreateProfileRequest {profile : " + profile + "}";
	}
	
}
