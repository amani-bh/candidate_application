package com.courzelo_for_business.candidate_application.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo_for_business.candidate_application.entities.CandidateApp;

@Repository
public interface CandidateAppRepository extends MongoRepository<CandidateApp,String> {
	
	//this repository contain all operations of mongodb
	public CandidateApp findByIdCandidateApp(String idCandidateApp);
	public List<CandidateApp> findByJobBusinessIdBusiness(String idBusiness);
	public boolean existsByJobIdJobAndUserId(String idJob,Long userId);
	
	public List<CandidateApp> findByJobIdJob(String idJob);
	public List<CandidateApp> findByUserId(long id);

}
