package com.testdemo.security.jwtsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.testdemo.security.jwtsecurity.model.User;
import com.testdemo.client.service.*;

@Controller
public class LoginController {

	LoginService loginService;

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("userName") String userName, @RequestParam("passWord") String password,
			Model model) {

		User user = new User(userName,password);
		
		loginService= new LoginService();
		if (loginService.login(user)) {
			model.addAttribute("user", user);
			return "registration";
		}
		return "error";
	}
}
