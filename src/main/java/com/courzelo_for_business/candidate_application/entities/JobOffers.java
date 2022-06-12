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

@Document(collection="JobOffers")
@Getter
@Setter
@AllArgsConstructor
public class JobOffers {

	
	
	    
	    @Id
	    @Field(targetType = FieldType.OBJECT_ID,value = "idJob")
	    private String idJob;

	    @Field(value = "title")
	    private String title;

	    @Field(value = "description")
	    private String description;
	    
	    @Field(value = "creationDate")
	    private Date creationDate;
	    
	    
	    @Field(value = "deadlineDate")
	    private Date deadlineDate;
	    
	    @Field(value = "startDate")
	    private Date startDate;
	    
	    @Field(value="industry")
	    private String industry;
	    
	    @Field(value="subIndustry")
	    private String subIndustry;
	    
	    @Field(value = "state")
	    private String state;
	    
	    @Field(value = "jobType") // CDI, ...
	    private String jobType;
	    
	    @Field(value="schedulesType")
	    private String schedulesType;
	    
	    @Field(value = "location")
	    private String location;
	    
	    @Field(value = "country")
	    private String country;
	    
	    @Field(value = "locationType")  //online , onsite , hypride
	    private String locationType;
	    
	    @Field(value = "requirement")
	    private List<String> requirement;

	    @Field(value = "hireNumber") // number of people wanting to hire
	    private int hireNumber;
	    
	    @Field(value = "salaryOption")
	    private String salaryOption;
	    
	    @Field(value = "salary")
	    private int salary;
	    
	    @Field(value = "salaryRangeMax")
	    private int salaryRangeMax;
	    
	    @Field(value = "salaryRangeMin")
	    private int salaryRangeMin;
	    
	    @Field(value = "salaryStartAmout")
	    private int salaryStartAmout;
	    
	    @Field(value = "salaryCurrency")
	    private String salaryCurrency;
	    
	    @Field(value = "jobBenefits")
	    private String jobBenefits;
	    
	    @Field(value = "communication")
	    private boolean communication;
	    
	    @Field(value = "communicationMails")
	    private List<String> communicationMails;

	    @Field(value = "business")
	    private Business business;
	    
	    @Field(value = "idPrehiringTest")
	    private String idPrehiringTest;
	    
	    @Field(value = "idTest")
	    private List<String> idTest;
	    
		public JobOffers() {}


	    
		
		
	    
	    
	    
}

