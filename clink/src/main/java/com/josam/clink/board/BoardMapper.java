package com.josam.clink.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getCategoryPosts(int categoryNo);
	public List<BoardVO> getBestCategoryPosts();
	public BoardVO getPost(int boardNo);
	public List<CommentVO> getPostsComment(int boardNo) throws Exception;
	public BoardVO bestPost(int boardNo);
	public List<BoardVO>getHotCategoryPosts(int categoryNo);
	public List<BoardVO>getHotBestCategoryPosts();
	public void insertComment(CommentVO vo);
}
