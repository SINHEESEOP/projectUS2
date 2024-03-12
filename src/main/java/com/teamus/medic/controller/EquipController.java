package com.teamus.medic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamus.medic.command.EquipVO;
import com.teamus.medic.equip.service.EquipService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/equip")
public class EquipController {
	
	@Autowired
	@Qualifier("equipService")
	private EquipService equipService;
	
	
	@GetMapping("/equipRentReg")
	public String equipRentReg() {
		return "equip/equipRentReg";
	}
	
	@PostMapping("/rentRegForm")
	public String rentRegForm(EquipVO vo) {
		
		
		return "equip/equipList";
	}
	
	
}
