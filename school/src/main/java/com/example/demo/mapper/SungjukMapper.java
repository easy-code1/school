package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.SungjukDto;

@Mapper
public interface SungjukMapper {
	public ArrayList<SungjukDto> sungjukList(int ban);
	public void sungjukAdd(int ban);
	public void sungjukUp(SungjukDto sdto);
}
