package com.josam.clink.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/clink/user")
@Controller
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/join.do")
	@ResponseBody
	public User_MasterVO join(@RequestBody User_MasterVO user_MasterVO) {
		int r = userService.insert(user_MasterVO);
		if (r == 1) {
			System.out.println("user_no:"+user_MasterVO.getUser_no()+" user_id:"+user_MasterVO.getUser_id());
			return user_MasterVO;
		} else {
			return null;
		}
	}

	@PostMapping("/login.do")
	@ResponseBody
	public User_MasterVO login(@RequestBody User_MasterVO user_MasterVO, HttpServletRequest req, HttpSession sess) throws Exception {
		User_MasterVO login = userService.login(user_MasterVO);
		System.out.println("login:" + login);
		if (login == null) {
			return null;
		} else {
			sess.setAttribute("loginSess", user_MasterVO);
			System.out.println("loginSess:" + sess.getAttribute("loginSess"));
			return login;
		}
	}

	// 아이디 중복체크
	@PostMapping("/check-duplicate-id.do")
	@ResponseBody
	public String checkDuplicateId(@RequestBody User_MasterVO user_MasterVO) {
		int checkDuplicateId = userService.checkDuplicateId(user_MasterVO.getUser_id());
		System.out.println(checkDuplicateId);
		if (checkDuplicateId == 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	// 개인정보 수정
	@PostMapping("/update.do")
	@ResponseBody
	public String update(@RequestBody User_MasterVO user_MasterVO) {
		int r = userService.update(user_MasterVO);
		if (r == 0) {
			System.out.println(user_MasterVO);
			return "fail";
		} else {
			return "success";
		}
	}
	
	@PostMapping("/registAccount.do")
	@ResponseBody
	public int registAccount(@RequestBody Account_DetailVO account_DetailVO, HttpServletRequest req) throws Exception {
		int registAccount = userService.registAccount(account_DetailVO);
		System.out.println("registAccount:" + registAccount);
		if (registAccount == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	@PostMapping("/checkAccount.do")
	@ResponseBody
	public List<Account_DetailVO> checkAccount(@RequestBody Account_DetailVO account_DetailVO, HttpServletRequest req) throws Exception {
		List<Account_DetailVO> checkAccount = userService.checkAccount(account_DetailVO);
		return checkAccount;
// 없으면 null 반환	

	}
}
