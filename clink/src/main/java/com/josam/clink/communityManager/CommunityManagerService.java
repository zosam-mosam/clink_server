package com.josam.clink.communityManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josam.clink.communityPost.CommunityPostVO;

import com.josam.clink.communityPost.CommunityPostVO;

@Service
public class CommunityManagerService {

	@Autowired
	CommunityManagerMapper communityManagerMapper;
	
	public CommunityPostVO getPost(int board_no) {
		return communityManagerMapper.getPost(board_no);
	}
	
	@Transactional
	void updateBoard(CommunityPostVO cpvo) {
		communityManagerMapper.updateBoard(cpvo);
	}
	
	public List<CommentVO> getComment(int board_no) {
		return communityManagerMapper.getComment(board_no);
	}
	
	@Transactional
	public void insertComment(CommentVO cvo) {
		communityManagerMapper.insertComment(cvo);
	}
	public int getCommentId() {
		return communityManagerMapper.getCommentId();
	}
	
	public void deleteBoard(int board_no) {
		communityManagerMapper.deleteBoard(board_no);
	}
	
	public void deleteComment(int comment_id) {
		communityManagerMapper.deleteComment(comment_id);
	}
	public void insertPost(CommunityPostVO pvo) {
		communityManagerMapper.insertPost(pvo);
	}
	public void insertHashtag(String category_no,String hashtag) {
		communityManagerMapper.insertHashtag(category_no,hashtag);
	}
	public void like(LikeVO lvo, int board_no) {
		communityManagerMapper.insertLike(lvo);
		communityManagerMapper.plusLike(board_no);
	}
	public void unlike(LikeVO lvo, int board_no) {
		communityManagerMapper.deleteLike(lvo);
		communityManagerMapper.minusLike(board_no);
	}
	
	public int getLike(String user_id, int board_no){
		return communityManagerMapper.getLike(user_id, board_no);
	}
	public int getCommentCount(int board_no) {
		return communityManagerMapper.getCommentCount(board_no);
	}

}
