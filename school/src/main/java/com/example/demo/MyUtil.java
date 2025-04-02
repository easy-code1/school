package com.example.demo;

import java.io.File;

import org.springframework.util.ResourceUtils;

public class MyUtil {

	public static String getRName2(String fname) throws Exception
	{ 		
		// 중복체크후 중복되지 않은 이름을 생성후
		String imsi=ResourceUtils.getFile("classpath:static/file").toString()+"/";
				
		File file=new File(imsi+fname); // new File(경로+파일명)
		
		String newFname=null;
		while(file.exists())
		{			
			String code=System.currentTimeMillis()+"";			
			
			// code를 가지고 새로운 파일명을 생성
			String[] names=fname.split("[.]");
		    newFname=names[0]+code+"."+names[1];
			
		    file=new File(imsi+newFname);
		} // while문 종료
		 
		 
		
		// 중복되지 않는 이름 리턴
		if(newFname!=null)
		   fname=newFname;
		
		return fname;
	}
	public static String getRName(String fname) throws Exception
	{ 		
		// 중복체크후 중복되지 않은 이름을 생성후
		String imsi=ResourceUtils.getFile("classpath:static/memo").toString()+"/";
				
		File file=new File(imsi+fname); // new File(경로+파일명)
		
		String newFname=null;
		while(file.exists())
		{			
			String code=System.currentTimeMillis()+"";			
			
			// code를 가지고 새로운 파일명을 생성
			String[] names=fname.split("[.]");
		    newFname=names[0]+code+"."+names[1];
			
		    file=new File(imsi+newFname);
		} // while문 종료
		 
		 
		
		// 중복되지 않는 이름 리턴
		if(newFname!=null)
		   fname=newFname;
		
		return fname;
	}
}
