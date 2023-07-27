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
	
}
