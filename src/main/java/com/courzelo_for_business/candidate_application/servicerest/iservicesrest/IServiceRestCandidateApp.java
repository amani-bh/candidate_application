package com.courzelo_for_business.candidate_application.servicerest.iservicesrest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.web.multipart.MultipartFile;

import com.courzelo_for_business.candidate_application.entities.LoadFile;
import com.courzelo_for_business.candidate_application.entities.dtos.CandidateAppDTO;
import com.courzelo_for_business.candidate_application.entities.dtos.StateDTO;



public interface IServiceRestCandidateApp {
	
	public List<CandidateAppDTO> getAllapplications();
	public CandidateAppDTO getCandidateById(String idCandidateApp );
	public List<CandidateAppDTO> getCandidateByJob(String idJob );
	public List<CandidateAppDTO> getCandidateByUser(String userId);
	public StateDTO getCurrentState(String idCandidateApp );
	public CandidateAppDTO addApp(CandidateAppDTO candidateApp,String idJob) throws IOException;
	public CandidateAppDTO updateApp(String idCandidateApp,CandidateAppDTO candidateApp);
	public CandidateAppDTO addState(String idCandidateApp,StateDTO candidateState);
	public void deleteApp(String idCandidateApp);
	public void sendMail(String email,String content) throws MessagingException, UnsupportedEncodingException;
	public CandidateAppDTO addCv(String idCandidateApp,MultipartFile cv) throws IOException ;
	public CandidateAppDTO saveOffer(String idCandidateApp,long idCandidateState,MultipartFile offerDoc) throws IOException ;
	public LoadFile getPdf(String pdf) throws IOException ;
	

}
