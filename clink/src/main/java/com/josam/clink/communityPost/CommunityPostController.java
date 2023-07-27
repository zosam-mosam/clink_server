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
	
	@GetMapping("/community/posts")
	@ResponseBody
	public List<CommunityPostVO> getPosts(@RequestParam String category_no, @RequestParam String filter){
		// 1. category_no = 0 => 베스트 게시판
		if("0".equals(category_no)) {
			return commPService.getBestPosts();
		}
		// 2. category_no != 0 && filter = 1 (최신순)
		if("1".equals(filter)){
			return commPService.getPostsbyRecent(category_no);
		}
		// 3. category_no != 0 && filter = 2 (인기순)
		if("2".equals(filter)){
			return commPService.getPostsbyLike(category_no);
		}
		return null;
		
	}
	
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
}
