package com.teamus.medic.program.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamus.medic.command.ProgramRegVO;
import com.teamus.medic.command.ProgramVO;
import com.teamus.medic.command.UserVO;

@Service("programService")
public class ProgramServiceImpl implements ProgramService {
	
	@Autowired
	private ProgramMapper programMapper;
	
	@Override
	public int programRegist(ProgramVO vo) {
		
		return programMapper.programRegist(vo);
	}

	@Override
	public List<ProgramVO> getProgramList() {
		
		return programMapper.getProgramList();
	}

	@Override
	public ProgramVO getDetail(int EVNT_NO) {
		
		return programMapper.getDetail(EVNT_NO);
	}

	@Override
	public void programUpdate(ProgramVO vo) {
		
		programMapper.programUpdate(vo);
		
	}

	@Override
	public void programDelete(int ENNT_NO) {
		
		programMapper.programDelete(ENNT_NO);
		
	}

	@Override
	public List<ProgramRegVO> getProgramRegList() {
		
		return programMapper.getProgramRegList();
		
		
	}

	@Override
	public UserVO getUser(String USER_NO) {
		
		
		return programMapper.getUser(USER_NO);
	}

	@Override
	public void programUserRegist(String USER_NO, int EVNT_NO) {
		
	programMapper.programUserRegist(USER_NO, EVNT_NO);
		
	}

	@Override
	public void deleteApply(int EVNT_REG_NO) {
		
		programMapper.deleteApply(EVNT_REG_NO);
		
	}

	@Override
	public List<ProgramRegVO> getProgramApplyList() {
	
		return programMapper.getProgramApplyList();
	}

	@Override
	public void applyUpdate(int EVNT_REG_NO) {
		
		programMapper.applyUpdate(EVNT_REG_NO);
		
	}

	@Override
	public void successUpdate(int ENVT_NO) {
		
		programMapper.successUpdate(ENVT_NO);
		
	}

}
