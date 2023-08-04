package com.josam.clink.user;

import lombok.Data;

@Data
public class Account_DetailVO {
	String account_no;
	String bank_code;
	String user_no;
	float account_balance;
	String account_code;
	String register_datetime;
	String register_id;
	String update_datetime;
	String update_id;

// react에서 보면서 맞추려고 남겨둠,,,.,,.,.,.,.,.,
//	String accountNumber;
//	int accountBalance;
//	int accountType;
//	int bankType;
}
