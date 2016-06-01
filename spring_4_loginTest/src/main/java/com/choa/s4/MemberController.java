package com.choa.s4;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.util.DBConnector;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login(){}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberDTO dto, HttpSession session, RedirectAttributes redirect){
		dto = new MemberDAO().login(dto);
		String path="";
		if(dto!=null){
			session.setAttribute("member", dto);
			redirect.addFlashAttribute("message", "login success");
			path ="redirect:/";
		}else{
			path = "member/login";
		}
		return path;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirect){
		redirect.addFlashAttribute("message", "logout success");
		session.invalidate();
		return "redirect:/";
	}

}
