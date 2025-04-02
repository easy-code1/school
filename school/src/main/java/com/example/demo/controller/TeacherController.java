package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.TeacherDto;
import com.example.demo.service.TeacherService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService service;
	
	@GetMapping("/teacher/tlist")
	public String tlist(Model model,HttpSession session) {
		return service.tlist(model,session);
	}
	
	@GetMapping("/teacher/twrite")
	public String twrite(HttpSession session) {
		return service.twrite(session);
	}
	
	@PostMapping("/teacher/twriteOk")
	public String twriteOk(TeacherDto tdto,HttpSession session) {
		return service.twriteOk(tdto,session);
	}
}
