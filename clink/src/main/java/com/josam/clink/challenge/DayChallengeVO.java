package com.josam.clink.challenge;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class DayChallengeVO {
	
	private int challengeId;
	private int userNo;
	private Timestamp successDate;
	private BigDecimal amount;
}
