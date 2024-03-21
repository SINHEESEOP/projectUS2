package com.teamus.medic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamus.medic.command.EquipVO;
import com.teamus.medic.equip.service.EquipService;


@Controller
@RequestMapping("/admin/equip")
public class EquipAdminController {
	
	@Autowired
	@Qualifier("equipService")
	private EquipService equipService;
	
	
	@GetMapping("/toEquipReg")
	public String toEquipReg() {
		return "admin/equip/equipReg";
	}
	
	
	@PostMapping("/istrRegForm")
	public String istrRegForm(EquipVO vo) {
		
		
		equipService.insertIstr(vo);
		
		
		
		return "admin/equip/regSucc";
	}
}
