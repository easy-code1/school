package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.CommDto;
import com.example.demo.service.CommService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CommController {
	@Autowired
	private CommService service;
	
	@GetMapping("/comm/write")
	public String write(@RequestParam String cla,Model model) {
		return service.write(cla,model);
	}
	
	@PostMapping("/comm/writeOk")
	public String writeOk(CommDto cdto,HttpSession session,MultipartFile file)throws Exception {
		return service.writeOk(cdto, session, file);
	}
	
	@GetMapping("/comm/list")
	public String list(HttpServletRequest request,HttpSession session,Model model) {
		return service.list(request, session, model);
	}
	
	@GetMapping("/comm/readnum")
	public String readnum(HttpServletRequest request) {
		return service.readnum(request);
	}
	
	@GetMapping("/comm/content")
	public String content(HttpServletRequest request,Model model) {
		return service.content(request, model);
	}
	
	@GetMapping("/comm/delete")
	public String delete(HttpServletRequest request) {
		return service.delete(request);
	}
	
	@GetMapping("/comm/update")
	public String update(HttpServletRequest request,Model model) {
		return service.update(request,model);
	}
	
	@PostMapping("/comm/updateOk")
	public String updateOk(CommDto cdto,@RequestParam String page,MultipartFile file)throws Exception {
		return service.updateOk(cdto,page,file);
	}
	
	@GetMapping("/comm/down")
	public void down(HttpServletRequest request,HttpServletResponse response)throws Exception{
		service.down(request, response);
	}
}
