package com.josam.clink.challenge;

import java.math.BigDecimal;

import com.josam.clink.user.UserVO;

import lombok.Data;

@Data
public class ChallengeVO {
	
	private int challengeId;
	private UserVO uvo;
	private String title;
	private String description;
	private BigDecimal goal;
}
