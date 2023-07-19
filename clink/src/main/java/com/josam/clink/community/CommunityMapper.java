package com.josam.clink.community;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityMapper {
	List<CommunityVO> list();
	List<CommunityVO> freeList(); 
	List<CommunityVO> infoList(); 
	List<CommunityVO> annList();
	void insertPost(CommunityVO cvo);
//	void insertHashTag(CommunityVO cvo);
}
