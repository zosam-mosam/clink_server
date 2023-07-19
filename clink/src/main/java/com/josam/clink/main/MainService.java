package com.josam.clink.main;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MainService {
	
	@Autowired
	MainMapper mainMapper;

	public QuoteVO getQuote(int no) {
		return mainMapper.getQuote(no);
	}

	public List<MonthDataVO> getMonthData(@Param("userNo") int userNo, @Param("yesterday") Date yesterday) {
		List<MonthDataVO> vo = mainMapper.getMonthData(userNo, yesterday);
		return vo;
	}

	public DataVO getData(@Param("userNo") Integer userNo, @Param("yesterday") Date yesterday) {
		DataVO dvo = mainMapper.getData(userNo, yesterday);
		dvo.setYesterday(dvo.getChallenge()- dvo.getSum());
		return dvo;
	}
	
	public Integer getUserNo(String id) {
		return mainMapper.getUserNo(id);
	}
}
