package com.josam.clink.communityPost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CommunityPostController {
	
	@Autowired
	CommunityPostService commPService;
	
	@GetMapping("/community/hot-posts")
	@ResponseBody
	public HotPostList getHotPost(){//최근 인기 게시물 가져오기
		HotPostList hpl = new HotPostList();
		hpl.setHotPost(commPService.HotPost());
		hpl.setHotFreePost(commPService.HotFreePost());
		hpl.setHotInfoPost(commPService.HotInfoPost());
		hpl.setHotAnnPost(commPService.HotAnnPost());
		return hpl;
	}
//	@GetMapping("community/post")
//	@ResponseBody
//	public List<CommunityPostVO> getPost() {
//		List<CommunityPostVO> PoList = commPService.getPost();
//		return PoList;
//	}
	@GetMapping("community/posts")
	@ResponseBody
	public void getPost(@RequestParam int category_no,@RequestParam int filter) {
		System.out.println("이건 카테고리번호:"+category_no);
		System.out.println("이건 필터번호:"+filter);
	}
}
