package com.sharma.nks.ht.daos;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharma.nks.ht.beans.Address;
import com.sharma.nks.ht.beans.Profile;
import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateProfileRequest;
import com.sharma.nks.ht.models.RtrvProfileResponse;

@Repository(value="profileDB")
public class ProfileDAO implements IProfileDAO {

	private Logger LOGGER=Logger.getLogger("DAO_LOGGER");
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public BaseResponse createProfile(CreateProfileRequest createProfileRequest) {
		Serializable szProfile = null;
		int szAddr = 0;
		BaseResponse resp=new BaseResponse();
		Session session=sessionFactory.openSession();
		Map<Object, Object> extension = new HashMap<Object,Object>();

		try{
			//szAddr=(Integer) session.save(createProfileRequest.getProfile().getAddress());
			szProfile=session.save(createProfileRequest.getProfile());
			
			if(null!=szProfile){
				extension.put("PID",szProfile);
				resp.setExtension(extension);
				resp.setResponseCode("000");
			}
		}catch(ConstraintViolationException cve){
			Address addr=createProfileRequest.getProfile().getAddress();
			addr.setId(szAddr);
			session.delete(addr);
			
			extension.put("PID",cve.getMessage());
			resp.setExtension(extension);
			resp.setResponseCode("999");
			
			LOGGER.error(cve.getCause());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return resp;
	}

	public RtrvProfileResponse viewAllProfiles() {
		RtrvProfileResponse resp;
		Session session=sessionFactory.openSession();
		
		Query qry=session.createQuery("from Profile");
		resp=(RtrvProfileResponse) qry.list();
		
		if(null!=resp){
			resp.setResponseCode("404");
		}
		
		return resp;
		
	}

	public RtrvProfileResponse viewProfileById(String pid) {

		RtrvProfileResponse resp;
		Session session=sessionFactory.openSession();
		
		resp=(RtrvProfileResponse) session.get(pid, Profile.class);
		if(null!=resp){
			resp.setResponseCode("404");
		}
		return resp;
	}

}
