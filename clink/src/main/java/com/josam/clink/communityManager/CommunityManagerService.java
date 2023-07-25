package com.josam.clink.communityManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josam.clink.communityPost.CommunityPostVO;

@Service
public class CommunityManagerService {

	@Autowired
	CommunityManagerMapper communityManagerMapper;
	
	public List<CommentVO> getComment(int board_no) {
		return communityManagerMapper.getComment(board_no);
	}
	
	public void insertComment(CommentVO cvo) {
		communityManagerMapper.insertComment(cvo);
	}
	public void insertPost(CommunityPostVO pvo) {
		communityManagerMapper.insertPost(pvo);
	}
	public void insertHashtag(String category_no,String hashtag) {
		communityManagerMapper.insertHashtag(category_no,hashtag);
	}
}
