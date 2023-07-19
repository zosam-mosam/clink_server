package com.josam.clink.board;

import java.sql.Date;

import lombok.Data;

@Data
public class CommentVO {
	private int commentId;
	private int boardNo;
	private int boardCategoryNo;
	private String commentWriter;
	private Date commentDate;
	private String commentContent;
	
}
