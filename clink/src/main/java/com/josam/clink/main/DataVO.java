package com.josam.clink.main;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DataVO {

	int sum; // 어제 사용 금액 계산 결과
	int challenge; // 전체 목표 금액
	int high; // 가장 높은 금액
	int low; // 가장 낮은 금액
	int avg; // 평균 사용금액
	int yesterday; // 어제 저축 금액

    public DataVO(int sum, int challenge, int high, int low, double avg) {
    	this.sum = sum;
		this.challenge = challenge;
		this.high = high;
		this.low = low;
		this.avg = (int)avg;
		this.yesterday = 0;
    }
}
