package com.example.demo.dto;

import lombok.Data;

@Data
public class TeacherDto {
	private int id,level,ban;
	private String userid,pwd,name;
	private String email,phone,writeday;
}
