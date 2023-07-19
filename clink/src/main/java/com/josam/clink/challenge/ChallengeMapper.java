package com.josam.clink.challenge;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.josam.clink.user.UserVO;

@Mapper
public interface ChallengeMapper {
	
	ChallengeVO myChallenge(UserVO vo);
	List<ExpenseVO> todayExpense(UserVO vo);
	List<ChartVO> weekExpense(UserVO vo);
	List<ExpenseVO> selectedExpense(ExpenseVO vo);
	List<DayChallengeVO> allExpense(ExpenseVO vo);
	List<DayChallengeVO> getTodayExpense(ExpenseVO vo);
	int insertDayChallenge(DayChallengeVO vo);
}
