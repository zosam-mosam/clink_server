package com.josam.clink.communityManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/community")
public class CommunityManagerController {
	@Autowired
	CommunityManagerService communityManagerService;
	
	
	
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
}
