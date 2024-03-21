package com.teamus.medic.equip.service;



import org.apache.ibatis.annotations.Mapper;

import org.springframework.web.bind.annotation.RequestParam;

import com.teamus.medic.command.EquipVO;
import com.teamus.medic.command.RentVO;




@Mapper
public interface EquipMapper {

	public int getCount();

	public EquipVO getData(int i);

	public String getCode(String structure);

	public EquipVO getDetail(String code);

	public EquipVO getIstr(String rntName);

	public void updateIstr(EquipVO vo2);

	public void rentReg(RentVO vo);

	public RentVO getRntlList(String userNo);

	public int getRntlCount(String userNo);

	public void updateIstr2(EquipVO vo1);

	public void deleteRntl(int rntlNo);

	public void insertIstr(EquipVO vo);

	

	

	

	


}
