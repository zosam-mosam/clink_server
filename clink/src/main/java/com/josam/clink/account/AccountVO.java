package com.josam.clink.account;

import lombok.Data;

@Data
public class AccountVO {
	int userNo;
	String accountNumber;
	int accountBalance;
	int accountType;
	int bankType;
}
