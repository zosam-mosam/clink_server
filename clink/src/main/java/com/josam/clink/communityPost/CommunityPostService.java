package com.josam.clink.communityPost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityPostService {
	
	@Autowired
	CommunityPostMapper mapper;
	
	public String test() {
		System.out.println("여기는 서비스");
		String test=mapper.testss();
		return test;
	}
	public List<CommunityPostVO> getPostsbyRecent(String category_no) {
		return mapper.getPostsbyRecent(category_no);
	}
	public List<CommunityPostVO> getPostsbyLike(String category_no){
		return mapper.getPostsbyLike(category_no);
	}
	public List<CommunityPostVO> getBestPosts(){
		return mapper.getBestPosts();
	}
	
	public List<CommunityPostVO> HotPost(){
		System.out.println("여기는 서비스");
		List<CommunityPostVO> list = mapper.list();
		return list;
	}
	public List<CommunityPostVO> HotFreePost(){
		List<CommunityPostVO> list = mapper.freeList();
		return list;
	}
	public List<CommunityPostVO> HotInfoPost(){
		List<CommunityPostVO> list = mapper.infoList();
		return list;
	}
	public List<CommunityPostVO> HotAnnPost(){
		List<CommunityPostVO> list = mapper.annList();
		return list;
	}
	
}
