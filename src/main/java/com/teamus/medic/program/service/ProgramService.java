package com.teamus.medic.program.service;

import java.util.List;

import com.teamus.medic.command.ProgramRegVO;
import com.teamus.medic.command.ProgramVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.util.Criteria;

public interface ProgramService {

	public int programRegist(ProgramVO vo);
	public List<ProgramVO> getProgramList(Criteria cri);
	public ProgramVO getDetail(int EVNT_NO);
	public void programUpdate(ProgramVO vo);
	public void programDelete(int EVNT_NO);
	public List<ProgramRegVO> getProgramRegList(String USERNAME , Criteria Cri);
	public UserVO getUser(String USER_NO);
	public void programUserRegist(String USERNAME , int EVNT_NO);
	public void deleteApply(int EVNT_REG_NO);
	public List<ProgramRegVO> getProgramApplyList(Criteria cri);
	public void applyUpdate(int EVNT_REG_NO);
	public void successUpdate(int EVNT_REG_NO);
	public int getProgramTotal();
	public int getProgramApplyTotal(Criteria cri);
	public int getUserApplyTotal(String USERNAME);
	public int programApplydelete(int EVNT_NO);
}
