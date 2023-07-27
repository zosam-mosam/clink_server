package com.josam.clink.challenge;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.josam.clink.user.UserVO;

@Mapper
public interface ChallengeMapper {
	
	List<HistoryVO> getALLHistory(UserVO vo);
	List<SuccessVO> getAllHistoryForInsertSuccess(UserVO vo);
	int insertSuccess(SuccessVO svo);
	ChallengeVO myChallenge(UserVO vo);
	List<HistoryVO> todayHistory(UserVO vo);
	List<HistoryVO> yesterdayHistory(UserVO vo);
	List<ChartVO> weekHistory(UserVO vo);
	List<HistoryVO> selectedHistory(HistoryVO vo);
	int deleteHistory(HistoryVO vo);
	int updateHistory(HistoryVO vo);
	
	
//	ChallengeVO myChallenge(UserVO vo);
//	List<HistoryVO> todayExpense(UserVO vo);
//	List<ChartVO> weekExpense(UserVO vo);
//	List<HistoryVO> selectedExpense(HistoryVO vo);
//	List<HistoryVO> allExpense(UserVO vo);
//	List<DayChallengeVO> getTodayExpense(HistoryVO vo);
//	int insertDayChallenge(DayChallengeVO vo);
}
