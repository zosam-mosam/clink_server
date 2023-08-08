package com.josam.clink.user;

import java.util.List;

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
		System.out.println("서비스 도착했니?? user_MasterVO:"+vo);
		
		User_MasterVO newVO = new User_MasterVO();
		newVO = userMapper.login(vo);
		
		String dbpwd = newVO.getPassword();
		boolean result = passwordEncoder.matches(vo.getPassword(), dbpwd);
		
		if(result) {
			return userMapper.login(vo);
		}else {
			return null;
		}
		
//		return userMapper.login(vo);
		
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
		String encodedPassword = passwordEncoder.encode(vo.getPassword());
		String encodedUsername = passwordEncoder.encode(vo.getUser_name());
		String encodedNickname = passwordEncoder.encode(vo.getNick_name());
	
		vo.setPassword(encodedPassword);
		vo.setUser_name(encodedUsername);
		vo.setEmail(encodedNickname);
		
		return userMapper.update(vo);
	}
	

	// 계좌 등록
	public int registAccount(Account_DetailVO vo) {
		return userMapper.registAccount(vo);
	}

	// 계좌 수정
	public int updateAccount(Account_DetailVO vo) {
		return userMapper.updateAccount(vo);
	}

	// 계좌 확인
	public List<Account_DetailVO> checkAccount(Account_DetailVO vo) {
		return userMapper.checkAccount(vo);
	}

}
