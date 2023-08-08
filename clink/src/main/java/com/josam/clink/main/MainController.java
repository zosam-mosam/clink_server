package com.josam.clink.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.josam.clink.challenge.ChallengeService;
import com.josam.clink.user.User_MasterVO;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	MainService mainService;
	
	@Autowired
	ChallengeService cService;
	
	@GetMapping("/info")
	@ResponseBody
	public MainPageVO getMainInfo(@RequestParam String userNo) {

		User_MasterVO uvo = new User_MasterVO();
		uvo.setUser_no(userNo);
		MainPageVO mpvo = mainService.getInfo(uvo);
		mpvo.setUser_no(userNo);
		
		//ReportData
		//mpvo.setReport(mainService.getReportData(cvo));

		return mpvo;
	}
	
}
