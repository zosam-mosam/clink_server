package com.josam.clink.communityPost;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommunityPostMapper {
	String testss();
	public List<CommunityPostVO> getPostsbyRecent(@Param("category_no")String category_no,@Param("hashtag")String hashtag);
	public List<CommunityPostVO> getPostsbyLike(@Param("category_no")String category_no,@Param("hashtag") String hashtag);
	public List<CommunityPostVO> getBestPosts();
	List<CommunityPostVO> list();
	List<CommunityPostVO> freeList(); 
	List<CommunityPostVO> infoList(); 
	List<CommunityPostVO> annList();
	List<String> getHashtag(int category_no);
}
