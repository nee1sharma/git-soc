package com.sharma.nks.ht.daos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharma.nks.ht.beans.Tutor;
import com.sharma.nks.ht.models.BaseResponse;
import com.sharma.nks.ht.models.CreateTutorRequest;
import com.sharma.nks.ht.models.TutorSearchRequest;
import com.sharma.nks.ht.models.TutorSearchResponse;

@Repository(value = "tutorDB")
public class TutorDAO implements ITutorDAO {

	private Logger LOGGER = Logger.getLogger("dao");
	private final int MAX_SIZE=5;


	@Autowired
	SessionFactory sessionFactory;
	

	public BaseResponse createTutor(CreateTutorRequest createTutorRequest) {
		LOGGER.info("TutorDAO --> createTutor(createTutorRequest)"+createTutorRequest);
		
		Session session=sessionFactory.openSession();
		Serializable szTutor = null;
		BaseResponse resp = new BaseResponse();

		try {
			szTutor=session.save(createTutorRequest.getTutor());
			
			if (null != szTutor) {
				resp.setResponseCode("000");
				Map<String, String> extension=new HashMap<>();
				extension.put("tid", szTutor.toString());
				resp.setExtension(extension);
				LOGGER.info("Tutor created with id: "+szTutor.toString());
			}
		} catch (Exception e) {
			LOGGER.error("TutorDAO createTutor() ----> " + e);
		}

		return resp;
	}

	public TutorSearchResponse viewAllTutors(int offset) {
		LOGGER.info("TutorDAO --> viewAllTutors with offset : "+offset);
		Session session=sessionFactory.openSession();

		TutorSearchResponse resp = new TutorSearchResponse();
		Query query=session.createQuery("from Tutor").setFirstResult(offset*MAX_SIZE).setMaxResults(offset);
		
		List<Tutor> tutorList=query.list();
		if (null != tutorList) {
			resp.setTutorList(tutorList);
			resp.setResponseCode("000");
			LOGGER.info("Records found.");
		}
		return resp;
	}

	public TutorSearchResponse viewTutorById(String tid) {
		LOGGER.info("TutorDAO --> viewTutorById with tid : "+tid);

		Session session=sessionFactory.openSession();
		TutorSearchResponse resp = new TutorSearchResponse();
		Tutor tutor=(Tutor) session.get(tid,Tutor.class);

		if (null != tutor) {
			resp.setResponseCode("000");
		}
		return resp;
	}

	public TutorSearchResponse findTutorByInclusiveCriteria(TutorSearchRequest searchRequest) {
		String qry="SELECT tid FROM Tutor WHERE ";
		TutorSearchResponse response=new TutorSearchResponse();
		String hql=searchTutorQuery(searchRequest);
		
		try {
			response.setResponseCode("000");
		} catch (Exception e) {
			response.setResponseCode("111");
			LOGGER.error("TutorDAO findTutorByInclusiveCriteria() ----> " + e);
		}
		
		
		return response;
	}
	
	private String searchTutorQuery(TutorSearchRequest req){
		StringBuilder sb=new StringBuilder();
		if(req.getExperience()>0){	
			sb.append("experience<=:experience AND ");
		}
		if(req.getStudentsTaught()>0){
			sb.append("studentsTaught<=:studentsTaught AND ");
		}
		int subs=req.getSubjectsTaught().size();
		for(int i=0;i<subs;i++){
			if(i!=0){
				sb.append(" OR ");
			}
			sb.append("subjectsTaught=:subjectsTaught"+i++);
		}
		return sb.toString();
	}

	private Map<String,String> searchTutorMap(TutorSearchRequest req){
		Map<String,String> mapReq=new HashMap<String,String>();
		if(req.getExperience()>0){	
			mapReq.put("experience", req.getExperience()+"");
		}
		if(req.getStudentsTaught()>0){
			mapReq.put("studentsTaught", req.getStudentsTaught()+"");
		}
		if(null!=req.getSubjectsTaught()){
			int i=0;
			for(String sub:req.getSubjectsTaught()){
				mapReq.put("subjectsTaught"+i++,sub);
			}
		}
		return mapReq;
	}
}
