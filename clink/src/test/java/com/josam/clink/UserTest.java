package com.josam.clink;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.josam.clink.challenge.ChallengeMapper;
import com.josam.clink.challenge.ChallengeVO;
import com.josam.clink.challenge.ChartVO;
import com.josam.clink.challenge.DayChallengeVO;
import com.josam.clink.challenge.ExpenseVO;
import com.josam.clink.user.UserController;
import com.josam.clink.user.UserMapper;
import com.josam.clink.user.User_MasterVO;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {
	
	@Test
	public void test() {
		System.out.println("sss");
	}
	
	@Autowired
	UserMapper mapper;
	
	@Test
	public void login() {
		User_MasterVO param = new User_MasterVO();
		param.setUser_id("gpd");
		param.setPassword("1234");
		User_MasterVO vo = mapper.login(param);
		System.out.println(vo);
	}
	

//	@Test
//	public void challenge() {
//		UserVO user= new UserVO();
//		user.setUserNO(1);
//		ChallengeVO c= new ChallengeVO();
//		c.setUvo(user);
//		c = mapper.myChallenge(user);
//		System.out.println(c.getTitle());
//		System.out.println(c.getDescription());
//		System.out.println(c.getGoal());
//	}

//	@Test
//	public void challenge() {
//		UserVO user= new UserVO();
//		user.setUserNo(1);
//		ChallengeVO c= new ChallengeVO();
//		c.setUvo(user);
//		c = mapper.myChallenge(user);
//		System.out.println(c.getTitle());
//		System.out.println(c.getDescription());
//		System.out.println(c.getGoal());
//	}

	
//	@Test
//	public void expense() {
//		ExpenseVO expense = new ExpenseVO();
//		User_MasterVO user= new User_MasterVO();
//		user.setUserNo(1);
//		ExpenseVO vo = new ExpenseVO();
//		vo.setUserNo(1);
//		List<ChartVO> vo_list = mapper.weekExpense(user);
//		for(ChartVO cvo: vo_list) {
//			System.out.println(cvo.getDate());
//		}
//	}
//	@Test
//	public void selectedExpense() {
//		ExpenseVO expense = new ExpenseVO();
//		expense.setUserNo(1);
//		String five = "2023-07-05%";
//		String seven = "2023-07-07%";
//		expense.setStartDate(five);
//		expense.setEndDate(seven);
//		List<ExpenseVO> vo_list =mapper.selectedExpense(expense);
//		for(ExpenseVO evo: vo_list) {
//			System.out.println(evo.getExpenseDate()+evo.getExpenseDescription()+" "+evo.getExpenseAmount());
//		}
//	}
//	
//	@Test
//	public void insertDayChall() {
//		ExpenseVO expense = new ExpenseVO();
//		expense.setUserNo(1);
//		List<DayChallengeVO> vo_list =mapper.getTodayExpense(expense);
//		BigDecimal goal = new BigDecimal(50000);
//		for(DayChallengeVO evo: vo_list) {
//			System.out.println(evo.getUserNo()+" "+evo.getSuccessDate()+" "+evo.getAmount());
//				
//			if (evo.getAmount().compareTo(goal)<=0) {
//				mapper.insertDayChallenge(evo);
//			}
//		}
//	}
//	@Autowired
//	UserMapper mapper;
//	
//	@Test
//	public void testInsert() {
//		UserVO user= new UserVO();
//		user.setUserId("GPT");
//		user.setUserName("지피티");
//		user.setNickname("지땡글");
//		user.setPwd("gpt1234");
//		user.setEmail("gpt@openai.com");
//		
//		mapper.insert(user);
//	}
	
//	@Autowired
//	UserMapper usermapper;
//	
//	@Test
//	public void UserLoginTest() {
//		User_MasterVO uvo = new User_MasterVO();
//		uvo.setUser_id("test");
//		uvo.setPassword("1234");
//		usermapper.login(uvo);
//		if(usermapper.login(uvo)!=null) {
//			System.out.println("로그인 성공");
//		}else {
//			System.out.println("로그인 실패");
//		}
//		
//	}
	
	
}
