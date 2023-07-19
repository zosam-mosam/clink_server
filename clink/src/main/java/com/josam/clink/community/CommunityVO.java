package com.josam.clink.community;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommunityVO {
	private int boardNo;
	private int boardCategoryNo;
	private int userNo;
	private int boardViews;
	private int boardLikes;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Timestamp boardDate;
	
	private HashTagVo[] hashTagVo;
}
