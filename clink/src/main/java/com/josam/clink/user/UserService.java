package com.josam.clink.user;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	public int insert(UserVO vo) {
		// 비밀번호 암호화
		System.out.println(vo.getUser_no());
		int r = userMapper.insert(vo);
		System.out.println(vo.getUser_no());
		return r;
	}
	
	public UserVO login(UserVO vo) {
		return userMapper.login(vo);
	}
	
	public UserVO getUserById(int userId) {
		return userMapper.selectUserById(userId);
	}
	
	public int checkDuplicateId(String userId) {
		return userMapper.checkDuplicateId(userId);
	}
	
	public int update(UserVO vo) {
		return userMapper.update(vo);
	}
	
	   
}
