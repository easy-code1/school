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
	
	@GetMapping("/teacher/tUpdate")
	public String tUpdate(int id,Model model,HttpSession session) {
		return service.tUpdate(id,model,session);
	}
	
	@PostMapping("/teacher/tUpdateOk")
	public String tUpdateOk(TeacherDto tdto,HttpSession session) {
		return service.tUpdateOk(tdto,session);
	}
	
	@GetMapping("/teacher/tDelete")
	public String tDelete(int id,HttpSession session) {
		return service.tDelete(id,session);
	}
	
	@GetMapping("/teacher/myInfo")
	public String myInfo(HttpSession session,Model model) {
		return service.myInfo(session,model);
	}
}
