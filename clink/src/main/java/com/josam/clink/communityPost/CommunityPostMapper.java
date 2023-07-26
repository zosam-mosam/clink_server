package com.josam.clink.communityPost;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityPostMapper {
	String testss();
	List<CommunityPostVO> list();
	List<CommunityPostVO> freeList(); 
	List<CommunityPostVO> infoList(); 
	List<CommunityPostVO> annList();
}
