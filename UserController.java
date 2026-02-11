package com.durgasoft.App018.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.durgasoft.App018.service.UserService;
import com.durgasoft.App018.user.User;	

@Controller
public class UserController {
	
	@Autowired	
	private UserService service;
	
	@GetMapping("/register")
	public String openRegisterForm() {
		
		return "user_form";
	}
	
	@GetMapping("/login")
	public String openLoginForm() {
		
		return "loginForm";
	}
	
	@PostMapping("/register_process")
	public String handleRegisterForm(@ModelAttribute User user) {
		
		String status = service.userRegister(user);
		
		if(status.equals("success")) {
			return "success";
		}else {
			return "failure";
		}
	}
	
	@PostMapping("/login_process")
	public String handleLoginForm(@RequestParam("email") String email,
											@RequestParam("password") String password) {
		
		String status = service.userLogin(email, password);
		
		if("success".equals(status)) {
			return "login_success";	
		}else {
			return "login_failure";		
		}
	}
	
}
