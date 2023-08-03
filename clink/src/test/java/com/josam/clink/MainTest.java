package com.josam.clink;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.josam.clink.challenge.ChallengeService;
import com.josam.clink.challenge.ChallengeVO;
import com.josam.clink.challenge.SuccessVO;
import com.josam.clink.main.MainMapper;
import com.josam.clink.main.MainService;
import com.josam.clink.main.ReportVO;
import com.josam.clink.main.StreakVO;
import com.josam.clink.main.StreakdataVO;
import com.josam.clink.user.User_MasterVO;

@SpringBootTest
@AutoConfigureMockMvc
public class MainTest {
	
	@Test
	public void test() {
		System.out.println("sss");
	}
	
	@Autowired
	MainMapper mapper;
	
	@Autowired
	MainService ms = new MainService();
	@Autowired
	ChallengeService cs = new ChallengeService();
	
	
	@Test
	public void streakTest() {
		User_MasterVO uvo = new User_MasterVO();
		uvo.setUser_no("00000");
		ChallengeVO cvo = cs.myChallenge(uvo);
		StreakVO svoList = ms.getStreakData(cvo);

		for(StreakdataVO svo: svoList.getStreakData()) {
			System.out.println(svo);
		}
	}
	
	@Test
	public void savingYesteday() {
		
		User_MasterVO uvo = new User_MasterVO();
		uvo.setUser_no("00000");
		ChallengeVO cvo = cs.myChallenge(uvo);
		SuccessVO svo = mapper.getYesterdaySaving(cvo);
		if(svo == null) System.out.println("Null");
		else System.out.println(svo.getChallenge_detail_success_date()+" "+svo.getChallenge_detail_success_amount()+" "+svo.getResult_success_amount());
	}
	
	@Test
	public void savingTotal() {
		
		User_MasterVO uvo = new User_MasterVO();
		uvo.setUser_no("00000");
		ChallengeVO cvo = cs.myChallenge(uvo);
		System.out.println(cvo.getChallenge_no()+" "+cvo.getUser_no()+" "+cvo.getChallenge_amount());
		SuccessVO svo = mapper.getTotalSaving(cvo);
		System.out.println(svo.getResult_success_amount());
	}
	
	@Test
	public void reportData() {
		
		User_MasterVO uvo = new User_MasterVO();
		uvo.setUser_no("00000");
		
		//System.out.println(cvo.getChallenge_no()+" "+cvo.getUser_no()+" "+cvo.getChallenge_amount());
		ReportVO rvo = mapper.getReportData(uvo);
		System.out.println(rvo);
	}
	
	@Test
	public void category() {
		
		User_MasterVO uvo = new User_MasterVO();
		uvo.setUser_no("00000");
		
		//System.out.println(cvo.getChallenge_no()+" "+cvo.getUser_no()+" "+cvo.getChallenge_amount());
		ReportVO rvo = mapper.getCategoryData(uvo);
		System.out.println(rvo);
	}
	
}
