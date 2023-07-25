package com.josam.clink.challenge;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.josam.clink.user.User_MasterVO;

@Mapper
public interface ChallengeMapper {
	
	ChallengeVO myChallenge(User_MasterVO vo);
	List<ExpenseVO> todayExpense(User_MasterVO vo);
	List<ChartVO> weekExpense(User_MasterVO vo);
	List<ExpenseVO> selectedExpense(ExpenseVO vo);
	List<DayChallengeVO> allExpense(ExpenseVO vo);
	List<DayChallengeVO> getTodayExpense(ExpenseVO vo);
	int insertDayChallenge(DayChallengeVO vo);
}
