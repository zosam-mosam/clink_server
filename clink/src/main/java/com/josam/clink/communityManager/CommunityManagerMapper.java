package com.josam.clink.communityManager;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.josam.clink.communityPost.CommunityPostVO;

@Mapper
public interface CommunityManagerMapper {
	
	public CommunityPostVO getPost(String board_no); 
	public void updateBoard(CommunityPostVO cpvo);
	public List<CommentVO> getComment(String board_no);
	public void insertComment(CommentVO cvo);
	public int getCommentId();
	public void deleteBoard(int board_no);
	public void deleteComment(int comment_id);
	public List<CommentVO> getComment(int board_no);
	void insertPost(CommunityPostVO pvo);
	void insertHashtag(String category_no,String hashtag);
}
