package com.sharma.nks.ht.daos;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharma.nks.ht.beans.Profile;
import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateProfileRequest;
import com.sharma.nks.ht.models.RtrvProfileResponse;

@Repository(value="profileDB")
public class ProfileDAO implements IProfileDAO {

	private Logger LOGGER=Logger.getLogger("DAO_LOGGER");
	private final int MAX_SIZE=5;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public BaseResponse createProfile(CreateProfileRequest createProfileRequest) {
		LOGGER.info("Create profile DAO -->createProfile(createProfileRequest)");
		
		Serializable szProfile = null;
		BaseResponse resp=new BaseResponse();
		Session session=sessionFactory.openSession();
		
		Map<String, String> extension = new HashMap<String,String>();
		try{
			//szAddr=(Integer) session.save(createProfileRequest.getProfile().getAddress());
			session.beginTransaction();
			szProfile=session.save(createProfileRequest.getProfile());
			session.getTransaction().commit();
			if(null!=szProfile){
				extension.put("PID",szProfile.toString());
				resp.setExtension(extension);
				resp.setResponseCode("000");
			}
		}catch(ConstraintViolationException cve){
			/*Address addr=createProfileRequest.getProfile().getAddress();
			session.delete(addr);
			
			extension.put("PID",cve.getMessage());
			resp.setExtension(extension);*/
			resp.setResponseCode("999");
			LOGGER.error(cve.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		
		
		return resp;
	}

	public RtrvProfileResponse viewAllProfiles(int offset) {
		LOGGER.info("Create profile DAO -->viewAllProfiles(offset)");

		RtrvProfileResponse resp=new RtrvProfileResponse();
		Session session=sessionFactory.openSession();
		
		Query qry=session.createQuery("from Profile").setFirstResult(offset*MAX_SIZE).setMaxResults(MAX_SIZE);
		List<Profile> profiles=qry.list();
		
		if(null!=profiles){
			resp.setProfiles(profiles);
			resp.setResponseCode("000");
		}
		
		return resp;
		
	}

	public RtrvProfileResponse viewProfileById(String pid) {
		LOGGER.info("Create profile DAO -->viewProfileById(pid)");

		RtrvProfileResponse resp = new RtrvProfileResponse();
		Session session=sessionFactory.openSession();
		
		Profile profile=(Profile) session.get(pid, Profile.class);
		if(null!=profile){
			resp.getProfiles().add(profile);
			resp.setResponseCode("000");
		}
		return resp;
	}

}
