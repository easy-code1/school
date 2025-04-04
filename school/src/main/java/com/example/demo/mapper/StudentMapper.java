package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.StudentDto;

@Mapper
public interface StudentMapper {
	public ArrayList<StudentDto> studentList(int ban);
	public int getBunho(int ban);
	public void studentAddOk(StudentDto sdto);
    public void studentUpdateOk(StudentDto sdto);
    public void studentDel(int id);
}
