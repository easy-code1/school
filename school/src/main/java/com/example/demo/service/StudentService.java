package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class StudentService {
	@Autowired
	private StudentMapper mapper;
	
	public String studentList(int ban,HttpSession session,Model model) {
		if(session.getAttribute("userid")==null)
		{
			return "redirect:/main/login";
		}
		else  
		{
			int ban2=Integer.parseInt(session.getAttribute("ban").toString());
			if(ban==ban2 || session.getAttribute("userid").equals("admin"))
			{
				ArrayList<StudentDto> slist=mapper.studentList(ban);
				model.addAttribute("slist",slist);
				model.addAttribute("ban",ban);
				
				return "/student/studentList";
			}
			else
			{
				return "redirect:/main/main";
			}
		}
	}
	
	public String studentAdd(int ban,HttpSession session,Model model) {
		if(session.getAttribute("userid")==null){
			return "redirect:/main/login";
		}
		else{
			model.addAttribute("ban",ban);
			return "/student/studentAdd";
		}
	}
	
	public String studentAddOk(StudentDto sdto,HttpSession session) 
	{
		if(session.getAttribute("userid")==null){
			return "redirect:/main/login";
		}
		else{
			int bunho=mapper.getBunho(sdto.getBan());
			sdto.setBunho(bunho);
			
			mapper.studentAddOk(sdto);
			
			return "redirect:/student/studentList?ban="+sdto.getBan();
		}
		
	}

	public String studentUpdateOk(StudentDto sdto, HttpSession session)
    {
		if(session.getAttribute("userid")==null){
			return "redirect:/main/login";
		}
		else{
			mapper.studentUpdateOk(sdto);
			
			return "redirect:/student/studentList?ban="+sdto.getBan();
		}
	}

	public String studentDel(int id,int ban, HttpSession session) 
	{
		if(session.getAttribute("userid")==null){
			return "redirect:/main/login";
		}
		else{
			mapper.studentDel(id);
			return "redirect:/student/studentList?ban="+ban;
		}
			
		
	}
	
}
