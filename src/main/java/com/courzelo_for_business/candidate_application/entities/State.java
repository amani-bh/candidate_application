package com.courzelo_for_business.candidate_application.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class State {

	 @Transient
     public static final String SEQUENCE_NAME = "applications_sequence";
	  private long idCandidateState; 
	  private Date stateDate;
	  private String label;
	  private int step;
	  private String idPrehiringTest;
	  private String idOtherTest;
	  private String idTest;
	  private String linkMeet;
	  private Date interviewDate;
	  private int score;
	  private int otherTestScore;
	  private boolean testState;
	  private String offerDoc;
	  public State() {}
}
