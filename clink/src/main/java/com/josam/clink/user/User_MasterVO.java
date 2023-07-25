package com.josam.clink.user;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class User_MasterVO {
	private char user_no;
	private String user_id;
	private String user_name;
	private String nick_name;
	private String password;
	private String email;
	private String phone_number;
	private String photo_url;
	private char user_status_yn;
	private Timestamp register_datetime;
	private String register_id;
	private Timestamp update_datetime;
	private String updater_id;	
	
	Account_DetailVO account_DetailVO;
}
