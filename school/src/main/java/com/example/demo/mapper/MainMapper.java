package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.TeacherDto;

@Mapper
public interface MainMapper {
	public boolean isTeacher(TeacherDto tdto);
	public TeacherDto getTeacher(String userid);
}
