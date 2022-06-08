package com.courzelo_for_business.candidate_application.entities;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document(collection="CandidateApp")
@Getter
@Setter
@AllArgsConstructor
public class CandidateApp {
	    
	    @Id
	    @Field(targetType = FieldType.OBJECT_ID,value = "idCandidateApp")
	    private String idCandidateApp;

	    @Field(value = "applicationDate")
	    private Date applicationDate;
	    
	    @Field(value = "userId")
	    private String userId;
	    
	    @Field(value = "idJob")
	    private String idJob;
	    
	    @Field(value = "cv")
	    private String cv;
	    
	    @Field(value = "idTest") 
	    private List<String> tests;
	    
	    @Field(value = "candidateState") 
	    private List<State> candidateState;

		
		public CandidateApp() {}
		
	    
	    
}
