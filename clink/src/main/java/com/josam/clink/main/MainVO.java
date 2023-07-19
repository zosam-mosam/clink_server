package com.josam.clink.main;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class MainVO {

	int status = 200;
	String userID;
	QuoteVO quote;
	List<MonthDataVO> monthData;
	DataVO vo;

	// 받는 값 :
	// userid / 퀴리조회를 위한 아이디 받기

	// 보내는 값 :

	// 사용자 이름
	// random quote,
	// 4month data Map,

	// 연속날짜 계산 결과 (4month data로 계산한 결과)
	// 전체 저축할 금액
	// 어제 레포트
	// 사용금액
	// max() sum()
}
