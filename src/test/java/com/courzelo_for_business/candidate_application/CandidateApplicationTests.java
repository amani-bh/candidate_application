package com.courzelo_for_business.candidate_application;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.courzelo_for_business.candidate_application.entities.dtos.CandidateAppDTO;
import com.courzelo_for_business.candidate_application.entities.dtos.StateDTO;
import com.courzelo_for_business.candidate_application.servicerest.iservicesrest.IServiceRestCandidateApp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateApplicationTests {

	@Autowired
	IServiceRestCandidateApp iServiceCandidateApp;
	
	/*
	@Test
    public void GetJobs()
    {       List<CandidateAppDTO> apps=iServiceCandidateApp.getAllapplications();
            Assert.assertEquals(apps.size(),1);
    }
	
	
	@Test
    public void GetJobByBusiness()
    {       List<CandidateAppDTO> apps=iServiceCandidateApp.getAppByBusiness("626b2efbf1d5b22ee0106932");
            Assert.assertEquals(apps.size(),1);
    }

	
	@Test
    public void GetJobByJob()
    {       List<CandidateAppDTO> apps=iServiceCandidateApp.getCandidateByJob("62a67bb814af075d45cdba27");
            Assert.assertEquals(apps.size(),1);
    }
	
	@Test
    public void GetJobByUser()
    {       List<CandidateAppDTO> apps=iServiceCandidateApp.getCandidateByUser((long) 1);
            Assert.assertEquals(apps.size(),1);
    }

	@Test
    public void GetCurrentState()
    {       StateDTO currentState=iServiceCandidateApp.getCurrentState("62a67cba84740a79b3de15c8");
            Assert.assertEquals(currentState.getLabel(),"pending");
    }
	
	@Test
    public void AddJob() throws IOException
    {        List<StateDTO> states=new ArrayList<StateDTO>();
		     StateDTO state=new StateDTO();
             state.setLabel("pending");
             state.setStateDate(new Date());      
		     CandidateAppDTO app=new CandidateAppDTO();
             app.setApplicationDate(new Date());
             states.add(state);
             app.setCandidateState(states);
            
    
             CandidateAppDTO res=iServiceCandidateApp.addApp(app,"62a67bcd14af075d45cdba28",(long)1);
             List<CandidateAppDTO> apps=iServiceCandidateApp.getAllapplications();
             Assert.assertEquals(apps.size(),2);
    }
	
	
	@Test
    public void UpdApp()
    {       
		
	    StateDTO state1=new StateDTO();
	    StateDTO state2=new StateDTO();
	    
	    state1.setLabel("pending");
        state1.setStateDate(new Date()); 
             
        state2.setLabel("screening");
        state2.setStateDate(new Date());
       
        List<StateDTO> states = new ArrayList<StateDTO>();
        
        states.add(state2);
        states.add(state1);
        
        CandidateAppDTO app=new CandidateAppDTO();
        app.setApplicationDate(new Date());
        app.setCandidateState(states);
        
        JobOffers job=new JobOffers();
        job.setIdJob("62a67bcd14af075d45cdba28");
        app.setJob(job);
        User user = new User();
        user.setId((long) 1);
        app.setUser(user);
       
        CandidateAppDTO res=iServiceCandidateApp.updateApp("62a75a921c51ac7f61a3b688",app);
        Assert.assertEquals(res.getCandidateState().size(),2);
		
    }*/
	
	
	@Test
    public void AddState()
    {    
       StateDTO state=new StateDTO();
	    
	    state.setLabel("interview");
        state.setStateDate(new Date()); 
        CandidateAppDTO res=iServiceCandidateApp.addState("62a75fef4614a90bd88ca8b9",state);
        Assert.assertEquals(res.getCandidateState().size(),3);
        
    }
    

}
