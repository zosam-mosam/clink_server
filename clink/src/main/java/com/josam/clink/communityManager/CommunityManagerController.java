package com.josam.clink.communityManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.josam.clink.communityPost.CommunityPostVO;

@Controller
@RequestMapping("/community")
public class CommunityManagerController {
	
	@Autowired
	CommunityManagerService communityManagerService;
	
	@PostMapping("/post/insert")
	@ResponseBody
	public void insertPost(@RequestBody CommunityPostVO pvo) {
		communityManagerService.insertPost(pvo);		
		System.out.println("여기는 인설트 컨드롤러");
		System.out.println(pvo);
		String[] hashtag_list=pvo.getHashtag_content().split(",");
		for(int i=0;i<hashtag_list.length;i++) {
			System.out.println(hashtag_list[i]);
			communityManagerService.insertHashtag(pvo.getCategory_no(),hashtag_list[i]);
		}
	}
	
	
	/**
	 * 
	 * @param board_no 게시물 번호
	 * @return 특정 게시물 번호에 달린 댓귿들을 list로 반환
	 */
	@GetMapping("/post/comment")
	@ResponseBody
	public List<CommentVO> getComment(@RequestParam int board_no){
		return communityManagerService.getComment(board_no);
	}
	
	/**
	 * 댓글달기
	 * parent_id가 안들어온 경우 -> 일반댓글
	 * parent_id가 들어온 경우 -> 대댓글
	 * @param vo
	 */
	@PostMapping("/post/comment/insert")
	@ResponseBody
	public void insertComment(@RequestBody CommentVO cvo) {
		if(cvo.getParent_id().isEmpty()) { // 일반댓글
			
		}
		communityManagerService.insertComment(cvo);
	}
}
