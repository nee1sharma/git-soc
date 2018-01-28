package com.sharma.nks.ht.daos;

import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateProfileRequest;
import com.sharma.nks.ht.models.RtrvProfileResponse;

/**
 * Profile related services under this interface
 * @author Heavens<br/> 
 * @since: Aug 27, 2017
 */
public interface IProfileDAO {
	
	/**
	 * 
	 * @param createProfileRequest
	 * @return responseCode 000: successful creation
	 */
	public BaseResponse createProfile(CreateProfileRequest createProfileRequest);

	/**
	 * List of all Profiles
	 * @return List of Profiles
	 */
	public RtrvProfileResponse viewAllProfiles(int offset);
	
	
	/**
	 * View Profile by id
	 * @param pid
	 * @return
	 */
	public RtrvProfileResponse viewProfileById(String pid);

}
