package com.josam.clink.board;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {

	int boardNo;
	int boardCategoryNo;
	int userNo;
	int boardViews;
	String boardTitle;
	String boardContent;
	Date boardDate;
	String boardWriter;
	int boardLikes;
	List<BoardVO> getCategoryPosts;
}
