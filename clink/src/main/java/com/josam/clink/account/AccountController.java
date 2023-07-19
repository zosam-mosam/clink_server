package com.josam.clink.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.josam.clink.user.UserVO;

@RequestMapping("/clink/account")
@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/registAccount.do")
	@ResponseBody
	public int registAccount(@RequestBody AccountVO accountVO, HttpServletRequest req) throws Exception {
		int registAccount = accountService.registAccount(accountVO);
		System.out.println("registAccount:" + registAccount);
		if (registAccount == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	@PostMapping("/checkAccount.do")
	@ResponseBody
	public List<AccountVO> checkAccount(@RequestBody AccountVO accountVO, HttpServletRequest req) throws Exception {
		List<AccountVO> checkAccount = accountService.checkAccount(accountVO);
		return checkAccount;
// 없으면 null 반환	

	}
}
