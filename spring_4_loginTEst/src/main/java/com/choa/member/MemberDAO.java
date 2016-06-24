package com.choa.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.choa.util.DBConnector;

import oracle.jdbc.proxy.annotation.Pre;

@Repository
public class MemberDAO {
	
	@Inject
	private DBConnector dbConnector;
	
	//join
	public int join(MemberDTO memberDTO){
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		String sql = "insert into member values(?,?,?,?)";
		int result=0;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			st.setString(3, memberDTO.getName());
			st.setInt(4, memberDTO.getAge());
			result= st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(st, con);
		}
		return result;
		
	}
	
	//login
	public MemberDTO login(MemberDTO memberDTO){
		Connection con = dbConnector.getConnect();
		PreparedStatement st=null;
		ResultSet rs= null;
		String sql = "select * from member where id=? and pw=?";
		try {
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			rs = st.executeQuery();
			if(rs.next()){
				memberDTO.setName(rs.getString("name"));
			}else {
				memberDTO= null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		return memberDTO;		
	}
	
	//아이디 중복확인
	public boolean idCheck(String id){
		Connection con = dbConnector.getConnect();
		String sql = "select * from member where id=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean check = false;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			if(rs.next()){
				check=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}	

}
