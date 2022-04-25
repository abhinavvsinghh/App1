package com.nagarro.advancedJava.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv  = new ModelAndView();
		
		HttpSession session=request.getSession();
		session.invalidate();
		
		mv.setViewName("Login");
		return mv;		
	}
}
