package com.josam.clink;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.josam.clink.user.UserMapper;
import com.josam.clink.user.UserService;
import com.josam.clink.user.User_MasterVO;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@Transactional
public class UserTest {
	
	@Test
	public void test() {
		long time = System.currentTimeMillis();
		System.out.println(time);
//		String time1 = Long.toString(time);
		
		String time1 = Long.toString(System.currentTimeMillis()).substring(8);
		
		System.out.println(time1);
//		1691737305034
	//  1691737331468
	}
	
	@Autowired
	UserMapper mapper;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Test
//    public void encrypt() {
//    	String dbpwd = passwordEncoder.encode("t1");
//    	System.out.println(dbpwd);
//    	User_MasterVO vo = new User_MasterVO();
//    	vo.setUser_id("t1");
//    	vo.setPassword("t1");
//    	User_MasterVO newVO = mapper.login(vo);
//    	System.out.println(vo.getPassword());
//    	System.out.println(newVO.getPassword());
//    	System.out.println(passwordEncoder.matches(vo.getPassword(), newVO.getPassword()));
//    	//System.out.println(passwordEncoder.matches("t6", "$2a$10$lO471nPoOLK3yQ7MmtK8Uu1UmZZNa8G3B6pu3T3LvEoVR.MTplMEe"));
//    }
    @Test
    public void encrypt() {
    	String dbpwd = passwordEncoder.encode("t1");
    	System.out.println(dbpwd);
    	User_MasterVO vo = new User_MasterVO();
    	vo.setUser_id("t1");
    	vo.setPassword("t1");
    	Map<String, Object> newVO = mapper.login(vo);
    	System.out.println(vo.getPassword());
    	System.out.println(((User_MasterVO) newVO).getPassword());
    	System.out.println(passwordEncoder.matches(vo.getPassword(), ((User_MasterVO) newVO).getPassword()));
    	//System.out.println(passwordEncoder.matches("t6", "$2a$10$lO471nPoOLK3yQ7MmtK8Uu1UmZZNa8G3B6pu3T3LvEoVR.MTplMEe"));
    }
//	@Test
//	public void login() {
//		User_MasterVO param = new User_MasterVO();
//		param.setUser_id("gpd");
//		param.setPassword("1234");
//		User_MasterVO vo = mapper.login(param);
//		System.out.println(vo);
//	}

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
	@Autowired
	UserService userService;
	
//	@Test
//	public void encodeTest() {
//		User_MasterVO vo = new User_MasterVO();
//		vo.setUser_no("10123");
//		vo.setUser_id("encode");
//		vo.setPassword("encode");
//		vo.setEmail("encode");
//		vo.setUser_name("테스트");
//		vo.setNick_name("테스트닉네임");
//		
//        // 비밀번호 암호화 및 저장
//        userService.insert(vo);
//
//        // 데이터베이스에서 사용자 정보 조회
//        User_MasterVO savedUser = userService.getUserById(vo.getUser_no());
//
//        // 비밀번호가 암호화되어 저장되었는지 확인
//        boolean isPasswordMatch = passwordEncoder.matches("encode", savedUser.getPassword());
//        assertEquals(true, isPasswordMatch);
//	}
	
	
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
