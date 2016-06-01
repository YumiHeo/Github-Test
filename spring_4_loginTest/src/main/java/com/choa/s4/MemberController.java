package com.choa.s4;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choa.util.DBConnector;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login(){}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberDTO dto, HttpSession session){
		dto = new MemberDAO().login(dto);
		String path="";
		if(dto!=null){
			session.setAttribute("member", dto);
			path ="redirect:/";
		}else{
			path = "member/login";
		}
		return path;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
