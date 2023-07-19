package com.josam.clink.main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	MainService mainService;
	
	@GetMapping("/info")
	@ResponseBody
	public MainVO getMainInfo(@RequestParam String userId) {

		MainVO mainVO = new MainVO();

		//userID
		mainVO.setUserID(userId);

		//userNo
		int userNo = mainService.getUserNo(userId);
		
		//Quote
		int quoteNumber = 2;
		QuoteVO quote = mainService.getQuote(quoteNumber);

		if(quote == null) System.out.println("quote Error");
		else mainVO.setQuote(quote);

		//Time set
		Date yesterday = Date.valueOf(LocalDate.now().plusDays(-1));
		
		// Month data Test
		List<MonthDataVO> monthData = mainService.getMonthData(userNo, yesterday);
		mainVO.setMonthData(monthData);

		//Data test
		DataVO dataVO = mainService.getData(userNo, yesterday);
		mainVO.setVo(dataVO);
		
		return mainVO;
	}
	
}
