package com.josam.clink.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josam.clink.user.UserVO;

@Service
public class ChallengeService {
	@Autowired
	ChallengeMapper mapper;
	
	public List<SuccessVO> getAllHistoryForInsertSuccess(UserVO vo){
		return mapper.getAllHistoryForInsertSuccess(vo);
	}
	
	public int insertSuccess(SuccessVO vo) {
		return mapper.insertSuccess(vo);
	}
	
	public ChallengeVO myChallenge(UserVO vo) {
		return mapper.myChallenge(vo);
	};
	
	public List<HistoryVO> todayHistory(UserVO vo) {
			
			return mapper.todayHistory(vo);
	}
	
	public List<HistoryVO> yesterdayHistory(UserVO vo) {
		
		return mapper.yesterdayHistory(vo);
}
	
	public List<ChartVO> weekHistory(UserVO vo){
		
		return mapper.weekHistory(vo);
	};
	
	public List<HistoryVO> selectedHistory(HistoryVO vo){
		
		return mapper.selectedHistory(vo);
	};
	
	public int deleteHistory(HistoryVO vo) {
		
		return mapper.deleteHistory(vo);
	};
	public int updateHistory(HistoryVO vo) {
			
		return mapper.updateHistory(vo);
	};
	
//	public ChallengeVO myChallenge(UserVO uservo) {
//		// 비밀번호 암호화
//		return mapper.myChallenge(uservo);
//	}
//	
//	public List<HistoryVO> todayExpense(UserVO vo) {
//		
//		return mapper.todayExpense(vo);
//	}
//	
//	public List<ChartVO> weekExpense(UserVO uvo){
//		
//		return mapper.weekExpense(uvo);
//	};
//	
//	public List<HistoryVO> selectedExpense(HistoryVO vo){
//		
//		return mapper.selectedExpense(vo);
//	};
}
