package com.nagarro.advancedJava.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advancedJava.service.Authentication;

@Controller
public class LoginController {
	
	@Autowired
	Authentication auth;
	
	@RequestMapping("/")
	public String home()
	{
		return "Login";
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) throws IllegalStateException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		boolean isValid = this.auth.validateUser(username, password);
		
		if(isValid) {
			mv.addObject("username", username);
			mv.setViewName("BookDetails");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("message", "invalid/wrong email or password");
			mv.setViewName("Login");
		}
		return mv;
	}
}
