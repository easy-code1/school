package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.SungjukDto;
import com.example.demo.service.SungjukService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SungjukController {
	@Autowired
	private SungjukService service;
	
	@GetMapping("/sungjuk/sungjukList")
	public String sungjukList(int ban,HttpSession session,Model model) {
		return service.sungjukList(ban,session,model);
	}
	
	@GetMapping("/sungjuk/sungjukAdd")
	public String sungjukAdd(int ban,HttpSession session) {
		return service.sungjukAdd(ban,session);
	}
	
	@PostMapping("/sungjuk/sungjukUp")
	public String sungjukUp(SungjukDto sdto,HttpSession session) {
		return service.sungjukUp(sdto, session);
	}
}
