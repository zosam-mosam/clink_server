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

	public int insert(User_MasterVO vo) {
		// 비밀번호 암호화
		System.out.println(vo.getUser_no());
		int r = userMapper.insert(vo);
		System.out.println(vo.getUser_no());
		return r;
	}
	
	public User_MasterVO login(User_MasterVO vo) {
		return userMapper.login(vo);
	}
	
	public User_MasterVO getUserById(int user_id) {
		return userMapper.selectUserById(user_id);
	}
	
	public int checkDuplicateId(String user_id) {
		return userMapper.checkDuplicateId(user_id);
	}
	
	public int update(User_MasterVO vo) {
		return userMapper.update(vo);
	}
	
	public int registAccount(Account_DetailVO vo) {
		return userMapper.registAccount(vo);
	}
	
	public List<Account_DetailVO> checkAccount(Account_DetailVO vo) {
		return userMapper.checkAccount(vo);
	}
	
	public boolean checkDuplicateEmail(String email) {
		// 1 -> 중복, 가입 불가 0 -> 가입 가능
		return userMapper.checkDuplicateEmail(email);
	}
	   
}
