package com.example.demo.service;

import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.MyUtil;
import com.example.demo.dto.MemoDto;
import com.example.demo.mapper.MemoMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class MemoService {
	@Autowired
	private MemoMapper mapper;
	
	public String send(HttpSession session,Model model) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			String userid=session.getAttribute("userid").toString();
    		
    		ArrayList<MemoDto> mlist=mapper.send(userid);
    		model.addAttribute("mlist",mlist);
    		
    		return "memo/send";
		}
	}
	
	public ArrayList<HashMap<String, String>> getUserid(){
		return mapper.getUserid();
	}
	
	public String memoWriteOk(MemoDto mdto,HttpSession session,MultipartFile file)throws Exception {
		if(!file.isEmpty()) {
			String ofname=file.getOriginalFilename();
			String sfname=MyUtil.getRName(ofname);
			String imsi=ResourceUtils.getFile("classpath:static/memo").toString()+"/";
			Path path=Paths.get(imsi+sfname);
			Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
			mdto.setOfname(ofname);
			mdto.setSfname(sfname);
		}
		mdto.setSeUserid(session.getAttribute("userid").toString());
		mapper.memoWriteOk(mdto);
		return "redirect:/memo/send";
	}
	
	public String receive(HttpSession session,Model model) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/main/login";
		}
		else {
			ArrayList<MemoDto> mlist=mapper.receive(session.getAttribute("userid").toString());
			model.addAttribute("mlist",mlist);
			return "/memo/receive";
		}
	}
	
	public String viewContent(HttpServletRequest request, Model model) {
		String id=request.getParameter("id");
		String ck=request.getParameter("ck");
		if(ck.equals("2")) {
			mapper.setState(id);
		}
		
		return mapper.getContent(id);
	}
	
	public void down(HttpServletRequest request,HttpServletResponse response)throws Exception {
		String ofname=request.getParameter("ofname");
		String sfname=request.getParameter("sfname");
		
		String path=ResourceUtils.getFile("classpath:static/memo").toString();
		
		response.setHeader("Content-Type", "application/octet-stream");
		ofname=URLEncoder.encode(ofname,"utf-8");
		response.setHeader("Content-Disposition","attachment; filename="+ofname);
		response.setContentType("application/unknown");
		
		Path path2=Paths.get(path+"/"+sfname);
		Files.copy(path2, response.getOutputStream());
		
	}
	
	public String cntMemo(HttpSession session) {
		String userid=session.getAttribute("userid").toString();
		return mapper.cntMemo(userid);
	}
}
