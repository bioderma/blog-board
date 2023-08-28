package com.example.blogboard.controller.api;

import com.example.blogboard.config.auth.PrincipalDetail;
import com.example.blogboard.dto.ReplySaveRequestDto;
import com.example.blogboard.dto.ResponseDto;
import com.example.blogboard.model.Board;
import com.example.blogboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;

	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		boardService.writePost(board, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id) {
		boardService.deletePost(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	@PutMapping("api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id,@RequestBody Board board){
		boardService.updatePost(id,board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto) {
		boardService.writeReply(replySaveRequestDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId) {
		boardService.deleteReply(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
}

