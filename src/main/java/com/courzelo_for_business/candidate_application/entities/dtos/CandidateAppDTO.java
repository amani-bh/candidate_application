package com.courzelo_for_business.candidate_application.entities.dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CandidateAppDTO {
	
	private String idCandidateApp;
    private Date applicationDate;
    private String userId;
    private String idJob;
    private String cv;
    private List<String> tests;
    private List<StateDTO> candidateState;
	public CandidateAppDTO() {}
	
	

    
}
