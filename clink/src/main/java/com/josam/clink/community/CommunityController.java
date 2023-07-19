package com.josam.clink.community;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommunityController {
	
	@Autowired
	CommunityService commService;
	
	@GetMapping("/community")
	@ResponseBody
	public PopularPostList BoardList(){
		System.out.println("여기는 깐뜨롤러");
		PopularPostList ppl = new PopularPostList();
		ppl.setPopularPost(commService.boardList());
		ppl.setPopularFreePost(commService.boardFreeList());
		ppl.setPopularInfoPost(commService.boardInfoList());
		ppl.setPopularAnnPost(commService.boardAnnList());
		return ppl;
	}
	
	@PostMapping("/insertPost")
	@ResponseBody
	public void InsertPost(@RequestBody CommunityVO cvo) {
		System.out.println("여기는 인썰sss트~");
		commService.insertPost(cvo);
//		commService.insertHashTag(cvo);
	}
//	@GetMapping("/community")
//	@ResponseBody
//	public String BoardList(){
//		System.out.println("찍혔다리");
//		return "하이";
//	}
}
