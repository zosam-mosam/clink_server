package com.josam.clink.main;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MainMapper {
	
	QuoteVO getQuote(int no);
	List<MonthDataVO> getMonthData(@Param("userNo") int userNo, @Param("yesterday") Date yesterday);
	DataVO getData(@Param("userNo") Integer id, @Param("yesterday") Date yesterday);
	Integer getUserNo(String id);
}
