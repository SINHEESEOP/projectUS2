package com.teamus.medic.equip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("equipService")
public class EquipServiceImpl implements EquipService{
	
	@Autowired
	private EquipMapper equipMapper;

}
