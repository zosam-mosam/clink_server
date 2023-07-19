package com.josam.clink.challenge;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ChallengePageVO {
	
	private int challengeId;
	private int userNo;
	private String title;
	private String description;
	private BigDecimal goal;
	private int value; //오늘 사용한 금액
	private List<ExpenseVO> today; //오늘자 거래내역
	private List<ChartVO> week; //일주일치 거래내역
	
}
