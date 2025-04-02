package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.MemoDto;
import com.example.demo.service.MemoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemoController {
	@Autowired
	private MemoService service;
	
	@GetMapping("/memo/send")
	public String send(HttpSession session,Model model) {
		return service.send(session,model);
	}
	
	@GetMapping("/memo/getUserid")
	public @ResponseBody ArrayList<HashMap<String, String>> getUserid(){
		return service.getUserid();
	}
	
	@PostMapping("/memo/memoWriteOk")
	public String memoWriteOk(MemoDto mdto,HttpSession session,MultipartFile file)throws Exception {
		return service.memoWriteOk(mdto, session, file);
	}
	
	@GetMapping("/memo/receive")
	public String receive(HttpSession session,Model model) {
		return service.receive(session,model);
	}
	
	@GetMapping("/memo/viewContent")
	public @ResponseBody String viewContent(HttpServletRequest request, Model model) {
		return service.viewContent(request,model);
	}
	
	@GetMapping("/memo/down")
	public void down(HttpServletRequest request,HttpServletResponse response)throws Exception {
		service.down(request,response);
	}
}
