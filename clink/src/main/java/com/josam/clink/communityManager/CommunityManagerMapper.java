package com.josam.clink.communityManager;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.josam.clink.communityPost.CommunityPostVO;

@Mapper
public interface CommunityManagerMapper {
	public List<CommentVO> getComment(int board_no);
	void insertComment(CommentVO cvo);
	void insertPost(CommunityPostVO pvo);
	void insertHashtag(String category_no,String hashtag);
}
