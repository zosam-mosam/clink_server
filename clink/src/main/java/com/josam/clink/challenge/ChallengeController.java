package com.josam.clink.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.josam.clink.user.UserVO;

//http://localhost:port/challenge/index.do?userNo=1
@RequestMapping("/challenge")
@Controller
public class ChallengeController {
	@Autowired
	ChallengeService challengeService;

	@GetMapping("/index.do")
	@ResponseBody
	public ChallengePageVO challenge(@RequestParam String userNo) {
		
		UserVO uvo = new UserVO();
		uvo.setUserNo(Integer.parseInt(userNo));
		ChallengeVO cvo = challengeService.myChallenge(uvo);
		List<ExpenseVO> today = challengeService.todayExpense(uvo);
		int value=0;
		for(ExpenseVO evo: today) {
			value += evo.getExpenseAmount();
		}
		
		ChallengePageVO cpvo = new ChallengePageVO();
		cpvo.setChallengeId(cvo.getChallengeId());
		cpvo.setTitle(cvo.getTitle());
		cpvo.setDescription(cvo.getDescription());
		cpvo.setGoal(cvo.getGoal());
		cpvo.setUserNo(uvo.getUserNo());
		cpvo.setValue(value);
		cpvo.setToday(today);
		cpvo.setWeek(challengeService.weekExpense(uvo));
		
		return cpvo; 
	}
	
	@GetMapping("/refresh.do")
	@ResponseBody
	public ChallengePageVO refresh(@RequestParam String userNo, String startDate, String endDate) {
		System.out.println(userNo);
		System.out.println(startDate);
		System.out.println(endDate);
		ExpenseVO evo = new ExpenseVO();
		evo.setUserNo(Integer.parseInt(userNo));
		evo.setStartDate(startDate+" 00:00:00");
		evo.setEndDate(endDate+" 23:59:59");
		ChallengePageVO cpvo = new ChallengePageVO();
		cpvo.setToday(challengeService.selectedExpense(evo));
		
		return cpvo;
	}
}
