package com.josam.clink.communityManager;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityManagerMapper {
	public List<CommentVO> getComment(int board_no);
	void insertComment(CommentVO cvo);
	
}
