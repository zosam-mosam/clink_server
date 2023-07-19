package com.josam.clink.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	public List<BoardVO> getCategoryPosts(int categoryNo) {
		List<BoardVO> vo = boardMapper.getCategoryPosts(categoryNo);
		return vo;
	}
	public List<BoardVO> getBestCategoryPosts() {
		List<BoardVO> vo = boardMapper.getBestCategoryPosts();
		return vo;
	}
	public List<BoardVO> getHotCategoryPosts(int categoryNo){
		List<BoardVO> vo = boardMapper.getHotCategoryPosts(categoryNo);
		return vo;
	}
	public List<BoardVO>getHotBestCategoryPosts(){
		List<BoardVO> vo = boardMapper.getHotBestCategoryPosts();
		return vo;
	}
	public BoardVO getPost(int boardNo) {
		return boardMapper.getPost(boardNo);
	}
	
	public List<CommentVO> getPostsComment(int boardNo) throws Exception {
		return boardMapper.getPostsComment(boardNo);
	}
}
