package com.teamus.medic.equip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamus.medic.command.EquipVO;
import com.teamus.medic.command.RentVO;

@Service("equipService")
public class EquipServiceImpl implements EquipService{
	
	@Autowired
	private EquipMapper equipMapper;

	@Override
	public int getCount() {
		
		return equipMapper.getCount();
	}

	@Override
	public EquipVO getData(int i) {
		
		return equipMapper.getData(i);
	}

	@Override
	public String getCode(String structure) {
		
		return equipMapper.getCode(structure);
	}

	@Override
	public EquipVO getDetail(String code) {
		
		return equipMapper.getDetail(code);
	}

	@Override
	public EquipVO getIstr(String rntName) {
		
		return equipMapper.getIstr(rntName);
	}

	@Override
	public void updateIstr(EquipVO vo2) {
		
		equipMapper.updateIstr(vo2);
		
	}

	@Override
	public void rentReg(RentVO vo) {
		
		equipMapper.rentReg(vo);
		
	}

	@Override
	public RentVO getRntlList(String userNo) {
		
		return equipMapper.getRntlList(userNo);
	}

	@Override
	public int getRntlCount(String userNo) {
		
		return equipMapper.getRntlCount(userNo);
	}

	@Override
	public void updateIstr2(EquipVO vo1) {
		
		equipMapper.updateIstr2(vo1);
		
	}

	@Override
	public void deleteRntl(int rntlNo) {

		equipMapper.deleteRntl(rntlNo);
		
	}

	

	
	

	

	

	
	

	
	

}
