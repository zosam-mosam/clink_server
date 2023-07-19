package com.josam.clink.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/community")// http://localhost:port/community/?category=
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping("/category")
	public @ResponseBody List<BoardVO> findCommonCategory(@RequestParam int categoryNo,@RequestParam int filter) throws Exception{
		System.out.println(filter);
		System.out.println(categoryNo);
		if(filter==1) {
			if(categoryNo!=3)return boardService.getCategoryPosts(categoryNo);
			else return boardService.getBestCategoryPosts();
		}
		else {
			if(categoryNo!=3) return boardService.getHotCategoryPosts(categoryNo);
			else return boardService.getHotBestCategoryPosts();
		}
		
	}
	
	@GetMapping("/post")
	public @ResponseBody BoardVO getPostConetent(@RequestParam int boardNo) {
			return boardService.getPost(boardNo);
		
	}
	@GetMapping("/post/comment")
	public @ResponseBody List<CommentVO> getComments(@RequestParam int boardNo) throws Exception {
		return boardService.getPostsComment(boardNo);
	}
	
}
