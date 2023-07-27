package com.josam.clink.challenge;

import java.math.BigDecimal;

import com.josam.clink.user.User_MasterVO;

import lombok.Data;

@Data
public class ChallengeVO {
	
	private int challengeId;
	private User_MasterVO uvo;
	private String title;
	private String description;
	private BigDecimal goal;
}
