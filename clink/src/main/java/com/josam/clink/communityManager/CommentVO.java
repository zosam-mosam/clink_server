package com.josam.clink.communityManager;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentVO {
	private String comment_id;
	private String board_no;
	private String comment_content;
	private Timestamp register_datetime;
	private String register_id;
	private Timestamp update_datetime;
	private String update_id;
	private String parent_id;
}
