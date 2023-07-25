package com.josam.clink.user;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class UserVO {
	private String user_no;
	private String user_id;
	private String user_name;
	private String nick_name;
	private String password;
	private String email;
	private String phone_number;
	private String photo_url;
	private String user_status_yn;
	
	private String register_datetime;
	private String register_id;
	private String update_datetime;
	private String update_id;
}
