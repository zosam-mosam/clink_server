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
	public List<CommunityPostVO> getPostsbyRecent(String category_no,String hashtag) {
		return mapper.getPostsbyRecent(category_no,hashtag);
	}
	public List<CommunityPostVO> getPostsbyLike(String category_no,String hashtag){
		return mapper.getPostsbyLike(category_no,hashtag);
	}
	public List<CommunityPostVO> getBestPosts(){
		return mapper.getBestPosts();
	}
	
	public List<CommunityPostVO> HotPost(){
		List<CommunityPostVO> list = mapper.list();
		ListCheck(list);
		return list;
	}
	public List<CommunityPostVO> HotFreePost(){
		List<CommunityPostVO> list = mapper.freeList();
		ListCheck(list);
		return list;
	}
	public List<CommunityPostVO> HotInfoPost(){
		List<CommunityPostVO> list = mapper.infoList();
		ListCheck(list);
		return list;
	}
	public List<CommunityPostVO> HotAnnPost(){
		List<CommunityPostVO> list = mapper.annList();
		ListCheck(list);
		return list;
	}
	public void ListCheck(List<CommunityPostVO> list) {
		CommunityPostVO CPV = new CommunityPostVO();
		CPV.setBoard_title("게시물이 존재하지 않습니다.");
		if(list.isEmpty()) {
			list.add(CPV);
		}
	}
	public List<String> getHashtag(int category_no){
		List<String> list = mapper.getHashtag(category_no);
		return list;
	}
	
}
