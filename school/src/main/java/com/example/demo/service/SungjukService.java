package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.dto.SungjukDto;
import com.example.demo.mapper.SungjukMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class SungjukService {
	@Autowired
	private SungjukMapper mapper;
	
	public String sungjukList(int ban,HttpSession session,Model model) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			int ban2=Integer.parseInt(session.getAttribute("ban").toString());
			if(ban==ban2) {
				model.addAttribute("slist",mapper.sungjukList(ban));
				model.addAttribute("ban",ban);
				return "/sungjuk/sungjukList";				
			}
			else {
				return "redirect:/main/error";				
			}
		}
	}
	
	public String sungjukAdd(int ban,HttpSession session) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			int ban2=Integer.parseInt(session.getAttribute("ban").toString());
			if(ban==ban2) {
				mapper.sungjukAdd(ban);
				return "redirect:/sungjuk/sungjukList?ban="+ban;				
			}
			else {
				return "redirect:/main/error";				
			}
		}
	}
	
	public String sungjukUp(SungjukDto sdto,HttpSession session) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			int ban2=Integer.parseInt(session.getAttribute("ban").toString());
			if(sdto.getBan()==ban2) {
				mapper.sungjukUp(sdto);
				return "redirect:/sungjuk/sungjukList?ban="+sdto.getBan();				
			}
			else {
				return "redirect:/main/error";				
			}
		}
	}
}
