package com.josam.clink.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	int insert(UserVO vo);
	UserVO login(UserVO vo);
	int checkDuplicateId(String userId);
	 UserVO selectUserById(int userId);
	 int update(UserVO vo);
}
