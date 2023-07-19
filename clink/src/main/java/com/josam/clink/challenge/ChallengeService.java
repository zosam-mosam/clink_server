package com.josam.clink.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josam.clink.user.UserVO;

@Service
public class ChallengeService {
	@Autowired
	ChallengeMapper mapper;

	public ChallengeVO myChallenge(UserVO uservo) {
		// 비밀번호 암호화
		return mapper.myChallenge(uservo);
	}
	
	public List<ExpenseVO> todayExpense(UserVO vo) {
		
		return mapper.todayExpense(vo);
	}
	
	public List<ChartVO> weekExpense(UserVO uvo){
		
		return mapper.weekExpense(uvo);
	};
	
	public List<ExpenseVO> selectedExpense(ExpenseVO vo){
		
		return mapper.selectedExpense(vo);
	};
}
