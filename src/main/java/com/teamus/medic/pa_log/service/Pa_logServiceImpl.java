package com.teamus.medic.pa_log.service;

import com.teamus.medic.command.Pa_logVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.utill.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("Pa_logService")
public class Pa_logServiceImpl implements Pa_logService {
	private Pa_logMapper paLogMapper;
	@Override
	public int regist(Pa_logVO vo) { return paLogMapper.regist(vo); }
	public ArrayList<UserVO> getListPop(Search search) {
		return paLogMapper.getListPop(search);
	}

}
