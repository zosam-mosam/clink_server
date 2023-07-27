package com.josam.clink.communityManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josam.clink.communityPost.CommunityPostVO;

@Service
public class CommunityManagerService {

	@Autowired
	CommunityManagerMapper communityManagerMapper;
	
	public CommunityPostVO getPost(String board_no) {
		return communityManagerMapper.getPost(board_no);
	}
	
	@Transactional
	void updateBoard(CommunityPostVO cpvo) {
		communityManagerMapper.updateBoard(cpvo);
	}
	
	public List<CommentVO> getComment(String board_no) {
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
}
