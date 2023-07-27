package com.josam.clink.communityPost;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityPostMapper {
	String testss();
	public List<CommunityPostVO> getPostsbyRecent(String category_no);
	public List<CommunityPostVO> getPostsbyLike(String category_no);
	public List<CommunityPostVO> getBestPosts();
	List<CommunityPostVO> list();
	List<CommunityPostVO> freeList(); 
	List<CommunityPostVO> infoList(); 
	List<CommunityPostVO> annList();
}
