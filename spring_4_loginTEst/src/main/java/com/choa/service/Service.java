package com.choa.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.member.MemberDTO;

public interface Service {
	
	//�α���
	public MemberDTO login(MemberDTO memberDTO);
	
	//ȸ������
	public void join(MemberDTO memberDTO, RedirectAttributes red);
	
	//ȸ������
	public void update(MemberDTO memberDTO);
	
	//ȸ������
	public void delete(MemberDTO memberDTO);
	
	//���̵� �ߺ�Ȯ��
	public String idCheck(String id);

}
