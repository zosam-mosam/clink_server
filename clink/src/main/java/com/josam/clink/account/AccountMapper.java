package com.josam.clink.account;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
	int registAccount(AccountVO vo);
	List<AccountVO> checkAccount(AccountVO vo);
}
