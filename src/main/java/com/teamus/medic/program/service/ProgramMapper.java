package com.teamus.medic.program.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.teamus.medic.command.ProgramRegVO;
import com.teamus.medic.command.ProgramVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.util.Criteria;

@Mapper
public interface ProgramMapper {
	
	public int programRegist(ProgramVO vo);
	public List<ProgramVO> getProgramList(Criteria cri);
	public ProgramVO getDetail(int EVNT_NO);
	public void programUpdate(ProgramVO vo);
	public void programDelete(int ENNT_NO);
	public List<ProgramRegVO> getProgramRegList(@Param("USERNAME") String USERNAME , @Param("cri") Criteria cri);
	public UserVO getUser(String USER_NO);
	public void programUserRegist(@Param("USERNAME") String USERNAME , @Param("EVNT_NO") int EVNT_NO);
	public void deleteApply(int EVNT_REG_NO);
	public List<ProgramRegVO> getProgramApplyList(Criteria cri);
	public void applyUpdate(int EVNT_REG_NO);
	public void successUpdate(int ENVT_NO);
	public int getProgramTotal();
	public int getProgramApplyTotal(Criteria cri);
	public int getUserApplyTotal(String USERNAME);
	public int programApplydelete(int EVNT_NO);
}
