package com.courzelo_for_business.candidate_application.servicerest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.courzelo_for_business.candidate_application.entities.CandidateApp;
import com.courzelo_for_business.candidate_application.entities.LoadFile;
import com.courzelo_for_business.candidate_application.entities.State;
import com.courzelo_for_business.candidate_application.entities.dtos.CandidateAppDTO;
import com.courzelo_for_business.candidate_application.entities.dtos.StateDTO;
import com.courzelo_for_business.candidate_application.repositories.CandidateAppRepository;
import com.courzelo_for_business.candidate_application.servicerest.iservicesrest.IServiceRestCandidateApp;






@Service
public class CandidateAppRestService implements IServiceRestCandidateApp {
	
	@Autowired
    private ModelMapper mapper;
    
    @Autowired
    private  CandidateAppRepository candidateAppRepository;
    
    @Autowired
    private  SequenceGeneratorService sequenceGeneratorService;
    
    @Autowired 
    private MongoTemplate mongoTemplate;
    
    @Autowired	
	JavaMailSender mailSender;
    
    @Autowired
    private FileService fileService;
    
   
    

	public List<CandidateAppDTO> getAllapplications(){
		List<CandidateApp> apps = candidateAppRepository.findAll();
		return apps.stream().map(app -> mapper.map(app, CandidateAppDTO.class))
		.collect(Collectors.toList());
		
		
	}
	
	
	public CandidateAppDTO getCandidateById(String idCandidateApp ) {
	
		CandidateApp app = candidateAppRepository.findByIdCandidateApp(idCandidateApp); 
		
		
		return mapper.map(app, CandidateAppDTO.class);
		
	}
	
	
	
	public List<CandidateAppDTO> getCandidateByUser(String userId) {
		
		List<CandidateApp> apps = candidateAppRepository.findByUserId(userId);
		return apps.stream().map(app -> mapper.map(app, CandidateAppDTO.class))
				.collect(Collectors.toList());
		
	}
	
	public List<CandidateAppDTO> getCandidateByJob(String idJob) {
	
		List<CandidateApp> apps = candidateAppRepository.findByIdJob(idJob);
		return apps.stream().map(app -> mapper.map(app, CandidateAppDTO.class))
				.collect(Collectors.toList());
		
	}
	
	
	public StateDTO getCurrentState(String idCandidateApp) {
		CandidateApp app = candidateAppRepository.findByIdCandidateApp(idCandidateApp); 
		
		  State state = app.getCandidateState().get(app.getCandidateState().size()-1);
		 
		  return  mapper.map(state, StateDTO.class);
		
	}
	
	public CandidateAppDTO addApp(CandidateAppDTO candidateApp,String idJob) throws IOException {
		if(candidateAppRepository.existsByIdJobAndUserId(idJob,candidateApp.getUserId())) {
		   throw new IOException("Application for this job already exist");
		}
		else {
		    CandidateApp app=mapper.map(candidateApp, CandidateApp.class);
			app.setIdJob(idJob);
		    CandidateApp newApp = candidateAppRepository.save(app);
		    return mapper.map(newApp, CandidateAppDTO.class);
		}
		       
	}
	
	public CandidateAppDTO updateApp(String idCandidateApp,CandidateAppDTO candidateApp) {

		CandidateApp app = mapper.map(candidateApp, CandidateApp.class);
		
		CandidateApp theApp = candidateAppRepository.findByIdCandidateApp(idCandidateApp);
    	theApp.setIdJob(app.getIdCandidateApp());
    	theApp.setApplicationDate(app.getApplicationDate());
    	theApp.setCandidateState(app.getCandidateState());
    	theApp.setIdJob(app.getIdJob());
    	theApp.setTests(app.getTests());
    	theApp.setUserId(app.getUserId());
    	
    	CandidateApp newApp = candidateAppRepository.save(theApp);
		
    	
				
		return mapper.map(newApp,CandidateAppDTO.class);
		
	}
	
	
	public CandidateAppDTO addState(String idCandidateApp,StateDTO candidateState) {
		
		
		 State state = mapper.map(candidateState, State.class);
  	  
  	     state.setIdCandidateState(sequenceGeneratorService.generateSequence(State.SEQUENCE_NAME));
  	     
  	     Query query = new Query();
 	  
         query.addCriteria(Criteria.where("idCandidateApp").is(idCandidateApp));
         
         Update update = new Update();     
         
         update.addToSet("candidateState", state );
         
         mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().upsert(true), CandidateApp.class);
         CandidateApp app  = candidateAppRepository.findByIdCandidateApp(idCandidateApp);
        
    
         
         return mapper.map(app, CandidateAppDTO.class);
	}
	
	
	
	
	public void deleteApp(String idCandidateApp) {
		candidateAppRepository.deleteById(idCandidateApp);
		
	}
	
	public void sendMail(String email,String content) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("jagermaya2@gmail.com", "Courzelo for business Support");
	    helper.setTo(email);
	     
	    String subject = "Hello , ";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
		
	}
	
	
	
	
	public CandidateAppDTO addCv(String idCandidateApp,MultipartFile cv) throws IOException {
		    CandidateApp theApp = candidateAppRepository.findByIdCandidateApp(idCandidateApp);
		    theApp.setCv(fileService.addFile(cv));
		    CandidateApp newApp = candidateAppRepository.save(theApp);
		    return mapper.map(newApp, CandidateAppDTO.class);
		
		       
	}
	
	
	public CandidateAppDTO saveOffer(String idCandidateApp,long idCandidateState,MultipartFile offerDoc) throws IOException {
		
	    CandidateApp theApp = candidateAppRepository.findByIdCandidateApp(idCandidateApp);
	    theApp.getCandidateState().forEach(s->{
	    	if(s.getIdCandidateState()==idCandidateState) {
	    		try {
					s.setOfferDoc(fileService.addFile(offerDoc));
					
				    
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	    	}
	    });
	   
	    CandidateApp newApp = candidateAppRepository.save(theApp);
	    return mapper.map(newApp, CandidateAppDTO.class);
	
	       
}
	
	
	public LoadFile getPdf(String pdf) throws IOException {
		return fileService.downloadFile(pdf);
	    
	
	       
}
	
	
	
	
	
	

    
	
}
