package com.josam.clink.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	//회원가입
	public int insert(User_MasterVO vo) {
		// 비밀번호 암호화
		System.out.println(vo.getUser_no());
		int r = userMapper.insert(vo);
		System.out.println(vo.getUser_no());
		return r;
	}
	// 로그인
	public User_MasterVO login(User_MasterVO vo) {
		return userMapper.login(vo);
	}
	// 
	public User_MasterVO getUserById(int user_id) {
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
