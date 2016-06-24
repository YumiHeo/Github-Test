package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.choa.dao.BoardDAO;
import com.choa.util.DBConnector;

@Repository
public class NoticeDAOImplBoardDAO implements BoardDAO {

	@Inject
	private DBConnector dbConnector;
	
	@Override
	public List<NoticeDTO> list(int curPage) {
		Connection con = dbConnector.getConnect();
		String sql = "select * from notice_board where "
				+ "rownum between 1 and 10 "
				+ "order by num desc";
		PreparedStatement st=null;
		ResultSet rs = null;
		ArrayList<NoticeDTO> ar = new ArrayList<>();
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setNum(rs.getInt("num"));
				noticeDTO.setId(rs.getString("id"));
				noticeDTO.setTitle(rs.getString("title"));
				noticeDTO.setContents(rs.getString("contents"));
				noticeDTO.setReg_date(rs.getDate("reg_date"));
				ar.add(noticeDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		return ar;
	}

	@Override
	public NoticeDTO view(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int write(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
