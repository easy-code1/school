package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.TeacherDto;

@Mapper
public interface TeacherMapper {
	public ArrayList<TeacherDto> tlist();
	public void twriteOk(TeacherDto tdto);
	public TeacherDto getTeacher(int id);
	public TeacherDto getTeacher2(String userid);
	public void tUpdateOk(TeacherDto tdto);
	public void tDelete(int id);
	
}
