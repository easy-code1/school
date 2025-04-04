package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.dto.TeacherDto;
import com.example.demo.mapper.TeacherMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class TeacherService {
	@Autowired
	private TeacherMapper mapper;
	
	public String tlist(Model model,HttpSession session) {
		if(session.getAttribute("userid")!=null && Integer.parseInt(session.getAttribute("level").toString()) >= 80) {
			ArrayList<TeacherDto> tlist=mapper.tlist();
			model.addAttribute("tlist",tlist);
			return "/teacher/tlist";
		}
		else if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			return "redirect:/main/main";
		}
	}
	
	public String twrite(HttpSession session) {
		
		if(session.getAttribute("userid")!=null && Integer.parseInt(session.getAttribute("level").toString()) >= 80) {
			return "/teacher/twrite";
		}
		else if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			return "redirect:/main/main";
		}
	}
	
	public String twriteOk(TeacherDto tdto,HttpSession session) {
		if(session.getAttribute("userid")!=null && Integer.parseInt(session.getAttribute("level").toString()) >= 80) {
			mapper.twriteOk(tdto);
			return "redirect:/teacher/tlist";
		}
		else if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			return "redirect:/main/main";
		}
	}
	
	public String tUpdate(int id,Model model,HttpSession session) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else if(Integer.parseInt(session.getAttribute("level").toString())<80) {
			return "redirect:/main/main";
		}
		else {
			model.addAttribute("tdto",mapper.getTeacher(id));
			return "/teacher/tUpdate";
		}
		
	}
	
	public String tUpdateOk(TeacherDto tdto,HttpSession session) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else if(Integer.parseInt(session.getAttribute("level").toString())<80) {
			return "redirect:/main/main";
		}
		else {
			mapper.tUpdateOk(tdto);
			return "redirect:/teacher/tlist";
		}
		
	}
	
	public String tDelete(int id,HttpSession session) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else if(Integer.parseInt(session.getAttribute("level").toString())<80) {
			return "redirect:/main/main";
		}
		else {
			mapper.tDelete(id);
			return "redirect:/teacher/tlist";
		}
	}
	
	public String myInfo(HttpSession session,Model model) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			TeacherDto tdto=mapper.getTeacher2(session.getAttribute("userid").toString());
			model.addAttribute("tdto",tdto);
			return "/teacher/myInfo";
		}
	}
}
