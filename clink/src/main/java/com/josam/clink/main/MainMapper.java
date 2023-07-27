package com.josam.clink.main;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.josam.clink.challenge.ChallengeVO;
import com.josam.clink.challenge.SuccessVO;
import com.josam.clink.user.UserVO;

@Mapper
public interface MainMapper {
	
	BadgeVO getBadge (UserVO vo);
	QuoteVO getQuote ();
	List<StreakdataVO> getStreakData(ChallengeVO vo);
	SuccessVO getYesterdaySaving(ChallengeVO vo);
	SuccessVO getTotalSaving(ChallengeVO vo);
	ReportVO getReportData(UserVO vo);
	ReportVO getCategoryData(UserVO vo);
	
	
//	QuoteVO getQuote(int no);
//	List<MonthDataVO> getMonthData(@Param("userNo") int userNo, @Param("yesterday") Date yesterday);
//	DataVO getData(@Param("userNo") Integer id, @Param("yesterday") Date yesterday);
//	Integer getUserNo(String id);
}
