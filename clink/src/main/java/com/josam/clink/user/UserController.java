package com.josam.clink.user;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/clink/user")
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	RegisterMail registerMail;


	// 회원가입
	@PostMapping("/join.do")
	@ResponseBody
	public User_MasterVO join(@RequestBody User_MasterVO user_MasterVO) {
		int r = userService.insert(user_MasterVO);
		if (r == 1) {
			System.out.println("user_no:" + user_MasterVO.getUser_no() + " user_id:" + user_MasterVO.getUser_id());
			return user_MasterVO;
		} else {
			return null;
		}
	}

	// 로그인
	@PostMapping("/login.do")
	@ResponseBody
	public User_MasterVO login(@RequestBody User_MasterVO user_MasterVO, HttpServletRequest req)
			throws Exception {
		User_MasterVO login = userService.login(user_MasterVO);
		System.out.println("login:" + login);
		if (login == null) {
			return null;
		} else {
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

	// 계좌 등록
	// 유형별로 1개 등록하면 더 이상 등록은 못하고 수정만 가능하다~~
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

	// 계좌 수정
	@PostMapping("/updateAccount.do")
	@ResponseBody
	public int updateAccount(@RequestBody Account_DetailVO account_DetailVO, HttpServletRequest req) throws Exception {
		int updateAccount = userService.updateAccount(account_DetailVO);
		System.out.println("updateAccount:" + updateAccount);
		if (updateAccount == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	// 등록된 계좌 있는지 확인
	@PostMapping("/checkAccount.do")
	@ResponseBody
	public List<Account_DetailVO> checkAccount(@RequestBody Account_DetailVO account_DetailVO, HttpServletRequest req)
			throws Exception {
		System.out.println("계좌 있는지 확인하자~~");
		System.out.println(account_DetailVO);

		List<Account_DetailVO> checkAccount = userService.checkAccount(account_DetailVO);
		return checkAccount;
		// 없으면 null 반환
	}

	// 프로필 이미지 등록
	@PostMapping("/photo-url.do")
	@ResponseBody
	public String profileImage(User_MasterVO user_MasterVO, MultipartFile file) {
		System.out.println("user_MasterVO" + user_MasterVO);
		System.out.println("file" + file);
		if (!file.isEmpty()) {
			String org = file.getOriginalFilename();
//				String ext = org.substring(org.lastIndexOf("."));
			System.out.println("업로드된 파일 이름:" + org);
//				String real = System.currentTimeMillis()+ext;
			user_MasterVO.setPhoto_url(org);
			String uploadFolder = "C:\\Users\\User\\Desktop\\2차Clink\\clink_server\\clink\\src\\main\\resources\\static\\img";
			File saveFile = new File(uploadFolder + "\\" + org);
			System.out.println("saveFile:" + saveFile);
			System.out.println("org:" + org);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int r = userService.profileImage(user_MasterVO);
			if (r == 1)
				return org;
			else
				return null;
		} else {
			return null;
		}
	}

	 // 이메일 인증
		@PostMapping("/emailAuth.do")
		@ResponseBody
		public String emailAuth(@RequestParam(value="email", required=false) String email) throws Exception{
			System.out.println("email:"+email);
			 String code = registerMail.sendSimpleMessage(email);
			   System.out.println("인증코드 : " + code);
			   return code;
		}
}