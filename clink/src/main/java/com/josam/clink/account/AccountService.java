package com.josam.clink.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {
	@Autowired
	AccountMapper accountMapper;
	
	public int registAccount(AccountVO vo) {
		return accountMapper.registAccount(vo);
	}
	
	public List<AccountVO> checkAccount(AccountVO vo) {
		return accountMapper.checkAccount(vo);
	}

}
