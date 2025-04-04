package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.CommDto;

@Mapper
public interface CommMapper {
	public void writeOk(CommDto cdto);
	public ArrayList<CommDto> list(int index,String cla);
	public void readnum(String id);
	public CommDto content(String id);
	public void delete(String id);
	public void updateOk(CommDto cdto);
	public int getChong(String cla);
}
