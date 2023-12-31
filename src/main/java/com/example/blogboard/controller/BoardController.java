package com.example.blogboard.controller;

import com.example.blogboard.model.Board;
import com.example.blogboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;


	//@GetMapping({"","/"})
	//public String index(Model model,@PageableDefault(size = 3,sort="id",direction =Direction.DESC)Pageable pageable) {
		//model.addAttribute("boards",boardService.listPost(pageable));
		//return "index";
	//}

	@GetMapping({"","/"})
	public String index(Model model,
						@PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable,
						@RequestParam(name = "searchType", required = false) String searchType,
						@RequestParam(name = "searchValue", required = false) String searchValue) {

		Page<Board> boards;

		if (searchType != null && searchValue != null) {
			boards = boardService.searchByTypeAndValue(searchType, searchValue, pageable);
		} else {
			boards = boardService.listPost(pageable);
		}

		model.addAttribute("boards", boards);
		return "index";
	}

	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.detailPost(id));
		
		return "board/detail";
	}
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.detailPost(id));
		return "board/updateForm";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
