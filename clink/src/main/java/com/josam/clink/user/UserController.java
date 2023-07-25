package com.josam.clink.user;

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
//	@Autowired
//	UserService userService;
//	
//	@PostMapping("/join.do")
//	@ResponseBody
//	public UserVO join(@RequestBody UserVO userVO) {
//		 int r = userService.insert(userVO);
//		 if (r == 1) {
//			 System.out.println(userVO);
//			 return userVO;
//		} else {
//			return null;
//		}
//	}
//	
//	@PostMapping("/login.do")
//	@ResponseBody
//	public UserVO login(@RequestBody UserVO userVO,  HttpServletRequest req, HttpSession sess) throws Exception {
//		UserVO login = userService.login(userVO);
//		System.out.println("login:"+login);
//		if (login == null) {
//			return null;
//		} else {
//			sess.setAttribute("loginSess", userVO);
//			System.out.println("loginSess:"+sess.getAttribute("loginSess"));
//			return login;
//		}
//	}
//
//	// 아이디 중복체크
//	@PostMapping("/check-duplicate-id.do")
//	@ResponseBody
//	public String checkDuplicateId(@RequestBody UserVO userVO) {
//		int checkDuplicateId = userService.checkDuplicateId(userVO.getUserId());
//		System.out.println(checkDuplicateId);
//		if (checkDuplicateId == 0) {
//			return "success";
//		} else {
//			return "fail";
//		}
//	}
//	
//
//	// 개인정보 수정
//	@PostMapping("/update.do")
//	@ResponseBody
//	public String update(@RequestBody UserVO userVO) {
//		 int r = userService.update(userVO);
//		 if (r == 0) {
//			 System.out.println(userVO);
//			 return "fail";
//		} else {
//			return "success";
//		}
//	}

}
