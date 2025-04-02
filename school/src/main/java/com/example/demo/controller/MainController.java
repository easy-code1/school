package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.TeacherDto;
import com.example.demo.service.MainService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@Autowired
	private MainService service;
	
	@GetMapping("/")
	public String home() {
		return service.home();
	}
	
	@GetMapping("/main/login")
	public String login() {
		return service.login();
	}
	
	@GetMapping("/main/main")
	public String main(HttpSession session) {
		return service.main(session);
	}
	
	@PostMapping("/main/loginOk")
	public String loginOk(TeacherDto tdto,HttpSession session) {
		return service.loginOk(tdto,session);
	}
	
	@GetMapping("/main/logout")
	public String logout(HttpSession session) {
		return service.logout(session);
	}
}
