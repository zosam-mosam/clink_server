package com.josam.clink.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
	
	@Autowired
	CommunityMapper mapper;
	
	public List<CommunityVO> boardList(){
		List<CommunityVO> list = mapper.list();
		return list;
	}
	public List<CommunityVO> boardFreeList(){
		List<CommunityVO> list = mapper.freeList();
		return list;
	}
	public List<CommunityVO> boardInfoList(){
		List<CommunityVO> list = mapper.infoList();
		return list;
	}
	public List<CommunityVO> boardAnnList(){
		List<CommunityVO> list = mapper.annList();
		return list;
	}
	public void insertPost(CommunityVO cvo) {
		mapper.insertPost(cvo);
	}
//	public void insertHashTag(CommunityVO cvo) {
//		for(int i=0;i<cvo.getHashTagVo().length;i++) {
//			mapper.insertHashTag(cvo.getHashTagVo()[i]);
//		}
//	}
}
