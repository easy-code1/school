package com.example.demo.service;

import java.io.File;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.MyUtil;
import com.example.demo.dto.CommDto;
import com.example.demo.mapper.CommMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class CommService {
	@Autowired
	private CommMapper mapper;
	
	public String write(String cla,Model model) {
		model.addAttribute("cla",cla);
		return "/comm/write";
	}
	
	public String writeOk(CommDto cdto,HttpSession session,MultipartFile file)throws Exception {
		if(file!=null && !file.isEmpty()) {
			String ofname=file.getOriginalFilename();
			String sfname=MyUtil.getRName2(ofname);
			String imsi=ResourceUtils.getFile("classpath:static/file").toString()+"/";
			Path path=Paths.get(imsi+sfname);
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			cdto.setOfname(ofname);
			cdto.setSfname(sfname);
		}
		cdto.setUserid(session.getAttribute("userid").toString());
		mapper.writeOk(cdto);
		return "redirect:/comm/list?cla="+cdto.getCla();
	}
	
	public String list(HttpServletRequest request,HttpSession session,Model model) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			String cla=request.getParameter("cla");
			int page=1;
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
			}
			int index=(page-1)*10;
			ArrayList<CommDto> clist=mapper.list(index, cla);
			model.addAttribute("clist",clist);
			model.addAttribute("cla",cla);
			model.addAttribute("page",page);
			return "/comm/list";
		}
	}
	
	public String readnum(HttpServletRequest request) {
		String id=request.getParameter("id");
		String page=request.getParameter("page");
		mapper.readnum(id);
		return "redirect:/comm/content?id="+id+"&page="+page;
	}
	
	public String content(HttpServletRequest request,Model model) {
		String id=request.getParameter("id");
		String page=request.getParameter("page");
		CommDto cdto=mapper.content(id);
		cdto.setContent(cdto.getContent().replace("\r\n", "<br>"));
		model.addAttribute("cdto",cdto);
		model.addAttribute("page",page);
		return "/comm/content";
	}
	
	public String delete(HttpServletRequest request) {
		String id=request.getParameter("id");
		String page=request.getParameter("page");
		String cla=request.getParameter("cla");
		mapper.delete(id);
		return "redirect:/comm/list?page="+page+"&cla="+cla;
	}
	
	public String update(HttpServletRequest request,Model model) {
		String id=request.getParameter("id");
		String page=request.getParameter("page");
		CommDto cdto=mapper.content(id);
		model.addAttribute("cdto",cdto);
		model.addAttribute("page",page);
		return "/comm/update";
	}
	
	public String updateOk(CommDto cdto,String page,MultipartFile file)throws Exception {
		if(file!=null && !file.isEmpty()) {
			String ofname=file.getOriginalFilename();
			String sfname=MyUtil.getRName2(ofname);
			String imsi=ResourceUtils.getFile("classpath:static/file").toString()+"/";
			Path path=Paths.get(imsi+sfname);
			File ff=new File(imsi+cdto.getSfname());
			if(ff.exists()) {
				ff.delete();
			}
			
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			cdto.setOfname(ofname);
			cdto.setSfname(sfname);
		}

		mapper.updateOk(cdto);
		
		return "redirect:/comm/content?id="+cdto.getId()+"&cla="+cdto.getCla()+"&page="+page;
	}
	
	public void down(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String sfname=request.getParameter("sfname"); 
		String ofname=request.getParameter("ofname"); 
		 
		String path=ResourceUtils.getFile("classpath:static/file").toString();
		
		response.setHeader("Content-Type", "application/octet-stream");
		ofname=URLEncoder.encode(ofname,"utf-8");
		response.setHeader("Content-Disposition","attachment; filename="+ofname);
		response.setContentType("application/unknown"); 
		              
		Path path2=Paths.get(path+"/"+sfname); 
		
		Files.copy(path2, response.getOutputStream());
	}
}
