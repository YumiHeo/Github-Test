package com.choa.s4;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;
import com.choa.member.ServiceImpl;
import com.choa.service.Service;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	private ServiceImpl si;
	//JoinForm
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public void join(){
		System.out.println("si : "+ si);
	}
	
	//Join Process
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO, RedirectAttributes red){
		/*ServiceImpl si = new ServiceImpl();*/
		si.join(memberDTO, red);
		return "redirect:/";
	}

	//loginForm
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login(){}
	
	//login process
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, RedirectAttributes redirect){
		
		/*Service si = new ServiceImpl();*/
		memberDTO=si.login(memberDTO);
		
		if(memberDTO != null){
			/*redirect.addFlashAttribute("message", "login success");*/
			session.setAttribute("member", memberDTO);
			return "redirect:/";
		}else {
			return "home";
		}
		
	}
	
	//id중복확인
	@RequestMapping("/idcheck")
	@ResponseBody //따로 조작없이 JSON으로 변경해서 감
	public MemberDTO idCheck(String id){
		MemberDTO m = new MemberDTO();
		m.setId("iu");
		m.setAge(26);
		m.setName("choa");
	/*	String message = si.idCheck(id);*/
		return m;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirect){
		redirect.addFlashAttribute("message", "logout success");
		session.invalidate();
		return "redirect:/";
	}
	
}
