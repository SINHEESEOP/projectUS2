package com.teamus.medic.program.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamus.medic.command.ProgramRegVO;
import com.teamus.medic.command.ProgramVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.util.Criteria;

@Service("programService")
public class ProgramServiceImpl implements ProgramService {
	
	@Autowired
	private ProgramMapper programMapper;
	
	@Override
	public int programRegist(ProgramVO vo) {
		
		return programMapper.programRegist(vo);
	}

	@Override
	public List<ProgramVO> getProgramList(Criteria cri) {
		
		return programMapper.getProgramList(cri);
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
	public List<ProgramRegVO> getProgramRegList(String USERNAME , Criteria cri) {
		
		return programMapper.getProgramRegList(USERNAME , cri);
		
		
	}

	@Override
	public UserVO getUser(String USERNAME) {
		
		
		return programMapper.getUser(USERNAME);
	}

	@Override
	public void programUserRegist(String USERNAME, int EVNT_NO) {
		
	programMapper.programUserRegist(USERNAME, EVNT_NO);
		
	}

	@Override
	public void deleteApply(int EVNT_REG_NO) {
		
		programMapper.deleteApply(EVNT_REG_NO);
		
	}

	@Override
	public List<ProgramRegVO> getProgramApplyList(Criteria cri) {
	
		return programMapper.getProgramApplyList(cri);
	}

	@Override
	public void applyUpdate(int EVNT_REG_NO) {
		
		programMapper.applyUpdate(EVNT_REG_NO);
		
	}

	@Override
	public void successUpdate(int EVNT_REG_NO) {
		
		programMapper.successUpdate(EVNT_REG_NO);
		
	}

	@Override
	public int getProgramTotal() {
		
		return programMapper.getProgramTotal();
	}

	@Override
	public int getProgramApplyTotal(Criteria cri) {
		
		return programMapper.getProgramApplyTotal(cri);
	}

	@Override
	public int getUserApplyTotal(String USERNAME) {
		
		return programMapper.getUserApplyTotal(USERNAME);
	}

	@Override
	public int programApplydelete(int EVNT_NO) {
		
		return programMapper.programApplydelete(EVNT_NO);
	}

}
