package com.josam.clink.user;

import lombok.Data;

@Data
public class UserVO {
	private int userNo;
	private String userId;
	private String userName;
	private String nickname;
	private String pwd;
	private String email;
	private String phoneNumber;
	private String photoUrl;
	private String userStatus;
	private String userSocial;
	private String userAccessToken;
	private String userUpdateToken;	

}
