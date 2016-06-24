package com.choa.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.choa.dao.BoardDAO;
import com.choa.service.BoardService;

@Service
public class NoticeServiceimplBoardService implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	

	@Override
	public void list(int curPage, Model model) {
		List<NoticeDTO>ar = boardDAO.list(curPage);
		model.addAttribute("list", ar);

	}

}
