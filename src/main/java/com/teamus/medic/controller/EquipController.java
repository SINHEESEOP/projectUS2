package com.teamus.medic.controller;

import java.net.http.HttpResponse;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.teamus.medic.command.EquipVO;
import com.teamus.medic.command.RentVO;
import com.teamus.medic.equip.service.EquipService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





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
	
	@GetMapping("/viewEquipList")
	public String viewEquipList(Model model) {
		int count=equipService.getCount();
		List<EquipVO>list = new ArrayList<>();
		for(int i =1;i<=count;i++) {
			list.add(equipService.getData(i));
		
		}
		model.addAttribute("equipList",list);
		
		
		return "equip/equipList";
	}
	
	
	@PostMapping("/rentRegForm")
	public String rentRegForm(RentVO vo) {
		
		
		String rntName=vo.getISTR_NM();
		EquipVO vo2=equipService.getIstr(rntName);
		if(vo2.getISTR_QTY()<vo.getRNTL_QTY()) {
			return "equip/ss";
		}else {
			vo2.setISTR_QTY(vo2.getISTR_QTY()-vo.getRNTL_QTY());
			equipService.updateIstr(vo2);
			equipService.rentReg(vo);
			return "equip/ss";
		}
		
		
		
	}
	
//	@PostMapping(value = "/viewDetail")
//	@ResponseBody
//	public EquipVO viewDetail(@RequestBody HashMap<Object,String> code) {
//		System.out.println(code.toString());
//		String isCode=code.values().toString().replace("[","").replace("]", "");
//		System.out.println(isCode);
//		EquipVO vo=equipService.getDetail(isCode);
//		System.out.println(vo.toString());
//		
//		return vo;
//		
//		
//	}
	
	@GetMapping("/popup")
	public String popup(Model model,@RequestParam("code")String code) {
		System.out.println(code);
		EquipVO vo=equipService.getDetail(code);
		System.out.println(vo.toString());
		model.addAttribute("vo",vo);
		return "equip/equipDetail";
	}
	
	
	
	
	
}
