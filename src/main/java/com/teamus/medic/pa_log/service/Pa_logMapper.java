package com.teamus.medic.pa_log.service;

import com.teamus.medic.command.Pa_logVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.utill.Search;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface Pa_logMapper {

	public int regist(Pa_logVO vo); // insert
	public ArrayList<UserVO> getListPop(Search search);
	public ArrayList<Pa_logVO> getListPaLog(String query);
	public UserVO getUser(String query);
	public int logInsert(Pa_logVO vo);
}