package com.teamus.medic.equip.service;

import com.teamus.medic.command.EquipVO;
import com.teamus.medic.command.RentVO;

public interface EquipService {

    public int getCount();

	public EquipVO getData(int i);

	public String getCode(String structure);

	public EquipVO getDetail(String code);

	public EquipVO getIstr(String rntName);

	public void updateIstr(EquipVO vo2);

	public void rentReg(RentVO vo);

	public RentVO getRntlList(String userNo);

	

	

	

	

	

}
