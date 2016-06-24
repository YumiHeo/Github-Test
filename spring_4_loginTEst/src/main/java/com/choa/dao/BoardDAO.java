package com.choa.dao;

import java.util.List;

import com.choa.notice.NoticeDTO;

public interface BoardDAO {
	
	//list
	public List<NoticeDTO> list(int curPage);
	
	//view
	public NoticeDTO view(int num);
	
	//write
	public int write(NoticeDTO noticeDTO);

}
