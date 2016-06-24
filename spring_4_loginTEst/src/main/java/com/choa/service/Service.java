package com.choa.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.member.MemberDTO;

public interface Service {
	
	//로그인
	public MemberDTO login(MemberDTO memberDTO);
	
	//회원가입
	public void join(MemberDTO memberDTO, RedirectAttributes red);
	
	//회원수정
	public void update(MemberDTO memberDTO);
	
	//회원삭제
	public void delete(MemberDTO memberDTO);
	
	//아이디 중복확인
	public String idCheck(String id);

}
