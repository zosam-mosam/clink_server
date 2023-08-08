package com.josam.clink;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.josam.clink.challenge.ChallengeService;
import com.josam.clink.challenge.ChallengeVO;
import com.josam.clink.challenge.SuccessVO;
import com.josam.clink.main.BadgeVO;
import com.josam.clink.main.MainMapper;
import com.josam.clink.main.MainService;
import com.josam.clink.main.QuoteVO;
import com.josam.clink.main.ReportVO;
import com.josam.clink.main.StreakVO;
import com.josam.clink.main.StreakdataVO;
import com.josam.clink.user.RegisterMail;
import com.josam.clink.user.User_MasterVO;

@SpringBootTest
@AutoConfigureMockMvc
public class MailTest {
	@Autowired
	RegisterMail registerMail;

	@Test
	public void test() {
		String email = "jin02019@naver.com";
		try {
			String code = registerMail.sendSimpleMessage(email);
			System.out.println("인증코드 : " + code);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
