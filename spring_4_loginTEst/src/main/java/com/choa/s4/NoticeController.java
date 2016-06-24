package com.choa.s4;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choa.service.BoardService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Inject
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String list(int curPage, Model model){
		boardService.list(curPage, model);
		return "notice/list";
	}
	
}
