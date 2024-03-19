package com.teamus.medic.pa_log.service;

import com.teamus.medic.command.Pa_logVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.utill.Search;

import java.util.ArrayList;

public interface Pa_logService {

	public int regist(Pa_logVO vo); // insert
	public ArrayList<UserVO> getListPop(Search search);



}
