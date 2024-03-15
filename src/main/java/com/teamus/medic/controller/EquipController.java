package com.teamus.medic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamus.medic.command.EquipVO;
import com.teamus.medic.command.RentVO;
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
	public String equipRentReg(Model model) {
		int count=equipService.getCount();
		List<EquipVO>list = new ArrayList<>();
		for(int i =1;i<=count;i++) {
			list.add(equipService.getData(i));
		
		}
		model.addAttribute("equipList",list);
		
		
		return "equip/equipRentReg";
	}
	
	@PostMapping("/rentRegForm")
	public String rentRegForm(RentVO vo) {
		System.out.println(vo.toString());
		String structure=vo.getISTR_NM();
		String istrCode=equipService.getCode(structure);
		vo.setISTR_NM(istrCode);
		System.out.println(vo.toString());
		
		
		return "equip/ss";
	}
	
	
}
