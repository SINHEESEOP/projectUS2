package com.teamus.medic.program.service;

import java.util.List;

import com.teamus.medic.command.ProgramRegVO;
import com.teamus.medic.command.ProgramVO;
import com.teamus.medic.command.UserVO;

public interface ProgramService {

	public int programRegist(ProgramVO vo);
	public List<ProgramVO> getProgramList();
	public ProgramVO getDetail(int EVNT_NO);
	public void programUpdate(ProgramVO vo);
	public void programDelete(int EVNT_NO);
	public List<ProgramRegVO> getProgramRegList();
	public UserVO getUser(String USER_NO);
	public void programUserRegist(String USER_NO , int EVNT_NO);
	public void deleteApply(int EVNT_REG_NO);
	public List<ProgramRegVO> getProgramApplyList();
	public void applyUpdate(int EVNT_REG_NO);
	public void successUpdate(int ENVT_NO);
}
