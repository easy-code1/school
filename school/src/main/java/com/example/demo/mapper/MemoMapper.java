package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.MemoDto;

@Mapper
public interface MemoMapper {
	public ArrayList<MemoDto> send(String userid);
	public ArrayList<HashMap<String, String>> getUserid();
	public void memoWriteOk(MemoDto mdto);
	public ArrayList<MemoDto> receive(String userid);
	public String getContent(String id);
	public void setState(String id);
	public String cntMemo(String userid);
}
