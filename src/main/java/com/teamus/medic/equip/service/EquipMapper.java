package com.teamus.medic.equip.service;



import org.apache.ibatis.annotations.Mapper;

import org.springframework.web.bind.annotation.RequestParam;

import com.teamus.medic.command.EquipVO;




@Mapper
public interface EquipMapper {

	public int getCount();

	public EquipVO getData(int i);

	public String getCode(String structure);

	public EquipVO getDetail(String code);

	

	

	


}
