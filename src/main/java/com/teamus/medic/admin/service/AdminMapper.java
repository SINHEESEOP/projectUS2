package com.teamus.medic.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.teamus.medic.command.adminVO;


@Mapper
public interface AdminMapper {
	
	public ArrayList<adminVO> getDscsnList();
	public adminVO getDetail(int DSCSN_SN);
	public void delete(int DSCSN_SN);
	public int DescsnUpdate (adminVO vo);
	public int insertDescsn(adminVO vo);
}
