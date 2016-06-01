package com.choa.s4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.choa.util.DBConnector;

public class MemberDAO {

	public MemberDTO login(MemberDTO dto){
		Connection con = DBConnector.getConnect();
		String sql = "select * from member where id=? and pw=?";
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, dto.getId());
			st.setString(2, dto.getPw());
			rs = st.executeQuery();
			if(rs.next()){
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setBirth(rs.getDate("birth"));
				dto.setLogintime(rs.getDate("logintime"));
			}else{
				dto= null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			dto=null;
			e.printStackTrace();
		}finally {
			DBConnector.disConnect(rs, st, con);
		}
		return dto;
	}
	
}
