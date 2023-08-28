package com.example.blogboard.service;

import com.example.blogboard.dto.ReplySaveRequestDto;
import com.example.blogboard.model.Board;
import com.example.blogboard.model.Users;
import com.example.blogboard.repository.BoardRepository;
import com.example.blogboard.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private ReplyRepository replyRepository;

	@Transactional
	public void writePost(Board board, Users user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);

	}

	@Transactional(readOnly = true)
	public Page<Board> listPost(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Board detailPost(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글상세보기 실패");
		});
	}

	@Transactional
	public void deletePost(int id) {
		boardRepository.deleteById(id);
	}

	@Transactional
	public void updatePost(int id, Board requesBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(() -> {
					return new IllegalArgumentException("글수정 실패");
				});
		board.setTitle(requesBoard.getTitle());
		board.setContent(requesBoard.getContent());
	}

	@Transactional
	public void writeReply(ReplySaveRequestDto replySaveRequestDto) {
		replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
	}

	@Transactional
	public void deleteReply(int replyId) {
		replyRepository.deleteById(replyId);
	}

	@Transactional(readOnly = true)
	public Page<Board> searchByTypeAndValue(String searchType, String searchValue, Pageable pageable) {
		switch (searchType) {
			case "제목":
				return boardRepository.findByTitleContaining(searchValue, pageable);
			// 다른 검색 유형에 대한 처리 추가 가능
			default:
				return boardRepository.findAll(pageable);
		}
	}

}


