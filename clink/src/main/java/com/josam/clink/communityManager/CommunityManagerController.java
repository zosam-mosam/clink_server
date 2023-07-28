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
	/**
	 * 
	 * @param board_no 게시물 번호
	 * @return 특정 게시물 번호의 내용 반환
	 */
	@GetMapping(value = {"/post", "/post/update"})
	@ResponseBody	
	public CommunityPostVO getPost(@RequestParam String board_no) {
		return communityManagerService.getPost(board_no);
	}

	@PostMapping("/post/insert")
	@ResponseBody
	public void insertPost(@RequestBody CommunityPostVO pvo) {
		communityManagerService.insertPost(pvo);
		System.out.println(pvo);
		String[] hashtag_list=pvo.getHashtag_content().split(",");
		for(int i=0;i<hashtag_list.length;i++) {
			System.out.println(hashtag_list[i]);
			communityManagerService.insertHashtag(pvo.getCategory_no(),hashtag_list[i]);
		}
	}
	
	@PostMapping("/post/update")
	@ResponseBody
	void updatePost(@RequestBody CommunityPostVO cpvo) {
		communityManagerService.updateBoard(cpvo);
		System.out.println(cpvo.getHashtag_content());
		System.out.println(cpvo.getBoard_title());
		System.out.println(cpvo.getBoard_content());
		System.out.println(cpvo.getCategory_no());
		System.out.println(cpvo.getRegister_id());
		System.out.println(cpvo.getBoard_no());
//		String[] hashtag_list=cpvo.getHashtag_content().split(",");
//		for(int i=0;i<hashtag_list.length;i++) {
//			System.out.println(hashtag_list[i]);
//			communityManagerService.insertHashtag(cpvo.getCategory_no(),hashtag_list[i]);
//		}
	}
	
	/**
	 * 
	 * @param board_no 게시물 번호
	 * @return 특정 게시물 번호에 달린 댓귿들을 list로 반환
	 */
	@GetMapping("/post/comment")
	@ResponseBody
	public List<CommentVO> getComment(@RequestParam String board_no){
		return communityManagerService.getComment(board_no);
	}
	
	/**
	 * 댓글달기
	 * parent_id = comment_id -> 일반댓글
	 * parent_id가 들어온 경우 -> 대댓글
	 * @param vo
	 */
	@PostMapping("/post/comment/insert")
	@ResponseBody
	public void insertComment(@RequestBody CommentVO cvo) {	
		cvo.setParent_id(communityManagerService.getCommentId()+1); // 현재 달릴 댓글의 id 받아오기 -> 대댓글이 아니면 parent_id와 comment_id 통일시키기
		communityManagerService.insertComment(cvo);
	}
	
	@PostMapping("/post/delete")
	@ResponseBody
	public void deleteBoard(int board_no) {
		// 게시글 생성한 사람만 삭제할 수 있게 예외처리하는걸 여기서해야할까
		// 어차피 프론트엔드 단에서 삭제, 수정 버튼은 생성한 사람만 보이게 할 것
		communityManagerService.deleteBoard(board_no);
	}
	
	@PostMapping("/post/comment/delete")
	@ResponseBody
	public void deleteComment(int comment_id) {
		communityManagerService.deleteComment(comment_id);
	}
}
