package com.mycom.myapp.user;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	UserServiceImpl service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public String loginCheck(HttpSession session, UserVO vo, Model model) {
		String returnURL ="";
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		UserVO loginvo = service.getUser(vo);
		if(loginvo != null) {
			System.out.println("로그인 성공");
			session.setAttribute("login", loginvo);
			session.setAttribute("id", loginvo.getUserid());
			returnURL = "redirect:list";
		} else {
			System.out.println("로그인 실패");
			returnURL = "redirect:login";
		}
		return returnURL;
	}
	
	//로그아웃 하는 부분
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	//public String login(String t, Model model)
}
