package com.josam.clink.communityPost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.josam.clink.jsouptest.JsoupTest;
import com.josam.clink.jsouptest.NewsVO;


@Controller
public class CommunityPostController {
	
	@Autowired
	CommunityPostService commPService;
	
	@GetMapping("/community/posts")
	@ResponseBody
	public List<CommunityPostVO> getPosts(@RequestParam String category_no, @RequestParam String filter, @RequestParam String hashtag ){
//		System.out.println(category_no);
		// 1. category_no = 0 => 베스트 게시판
		System.out.println(hashtag);
		if("0".equals(category_no)) {
			return commPService.getBestPosts();
		}
		// 2. category_no != 0 && filter = 1 (최신순)
		if("1".equals(filter)){
			return commPService.getPostsbyRecent(category_no,hashtag);
		}
		// 3. category_no != 0 && filter = 2 (인기순)
		if("2".equals(filter)){
			return commPService.getPostsbyLike(category_no,hashtag);
		}
		return null;
		
	}
	
	@GetMapping("/community/hot-posts")
	@ResponseBody
	public List<Object> getHotPost() throws IOException{//최근 인기 게시물 가져오기
		HotPostList hpl = new HotPostList();
		JsoupTest jtest =new JsoupTest();
		List<NewsVO> nvo=jtest.getNewsdata();
		NewsVO nv=nvo.get(0);
		hpl.setHotPost(commPService.HotPost());
		hpl.setHotFreePost(commPService.HotFreePost());
		hpl.setHotInfoPost(commPService.HotInfoPost());
		hpl.setHotAnnPost(commPService.HotAnnPost());
		List<Object> lo= new ArrayList<>();
		lo.add(hpl);
		lo.add(nvo);
		System.out.println(lo);
		return lo;
	}
	
	@GetMapping("/community/hot-hashtag")
	@ResponseBody
	public List<String> getHotHashtag(@RequestParam int category_no) {
		List<String> list=commPService.getHashtag(category_no);
//		System.out.println("이건 카테고리 번호:"+category_no);
		return list;
	}
}
