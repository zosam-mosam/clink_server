package com.josam.clink.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	// 회원가입
	public int insert(User_MasterVO vo) {
		// 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(vo.getPassword());
		String encodedUsername = passwordEncoder.encode(vo.getUser_name());
		String encodedEmail = passwordEncoder.encode(vo.getEmail());

		vo.setPassword(encodedPassword);
		vo.setUser_name(encodedUsername);
		vo.setEmail(encodedEmail);

		int r = userMapper.insert(vo);
		return r;
	}

	// 로그인	
	public User_MasterVO login(User_MasterVO vo) {
		User_MasterVO newVO = new User_MasterVO();
		newVO = userMapper.login(vo);
		boolean result = passwordEncoder.matches(vo.getPassword(), newVO.getPassword());
		System.out.println("result:"+result);
		if(result) {
			return newVO;
		}else {
			return null;
		}
	}

	// 정보 확인
	public User_MasterVO getUserInfo(User_MasterVO vo) {
		return userMapper.getUserInfo(vo);
	}
	
	public User_MasterVO getUserById(String user_id) {
		return userMapper.selectUserById(user_id);
	}

	// 아이디 중복확인
	public int checkDuplicateId(String user_id) {
		return userMapper.checkDuplicateId(user_id);
	}

	// 프로필 사진 업로드
	public int profileImage(User_MasterVO vo) {
		return userMapper.profileImage(vo);
	}

	// 개인정보 수정
	public int update(User_MasterVO vo) {
		if(vo.getNick_name().equals(null)) {
			User_MasterVO newVO = new User_MasterVO();
			vo.setNick_name(newVO.getNick_name());
		}else if(vo.getPassword().equals(null)) {
			User_MasterVO newVO = new User_MasterVO();
			vo.setNick_name(newVO.getNick_name());
		}		
		return userMapper.update(vo);
	}
	
	// 계좌 확인
		public List<Account_DetailVO> checkAccount(Account_DetailVO vo) {
			return userMapper.checkAccount(vo);
		}
	
	// 계좌 등록
	public int registAccount(Account_DetailVO vo) {
		return userMapper.registAccount(vo);
	}

	// 계좌 수정
	public int updateAccount(Account_DetailVO vo) {
		return userMapper.updateAccount(vo);
	}


}
