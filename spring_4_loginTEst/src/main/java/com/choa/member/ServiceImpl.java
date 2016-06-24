package com.choa.member;

import javax.inject.Inject;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	@Inject
	private MemberDAO mdao;
	
	
	public MemberDAO getMdao() {
		return mdao;
	}

	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}

	@Override
	public String idCheck(String id) {
		// TODO Auto-generated method stub
		boolean result = mdao.idCheck(id);
		if(result){
			return "no";
		}else{
			return "ok";
		}
	}

	@Override
	public MemberDTO login(MemberDTO memberDTO) {
		/*MemberDAO mdao = new MemberDAO();*/
		memberDTO = mdao.login(memberDTO);
		return memberDTO;
	}

	@Override
	public void join(MemberDTO memberDTO, RedirectAttributes red) {
		/*MemberDAO mdao = new MemberDAO();*/
		int result =mdao.join(memberDTO);
		if(result>0){
			red.addFlashAttribute("message", "회원가입 성공");
		}else {
			red.addFlashAttribute("message", "회원가입 실패");
		}

	}

	@Override
	public void update(MemberDTO memberDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MemberDTO memberDTO) {
		// TODO Auto-generated method stub

	}

}
