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
	
	
	@GetMapping("/toEquipHome")
	public String toEquipHome() {
		
		
		return "equip/equipHome";
	}
	
	
	
	@GetMapping("/toRentReg")
	public String toRentReg(Model model) {
		int count=equipService.getCount();
		List<EquipVO>list = new ArrayList<>();
		for(int i =1;i<=count;i++) {
			list.add(equipService.getData(i));
		
		}
		model.addAttribute("equipList",list);
		
		
		return "equip/equipRentReg";
	}
	
	@GetMapping("/toEquipList")
	public String toEquipList(Model model) {
		int count=equipService.getCount();
		List<EquipVO>list = new ArrayList<>();
		for(int i =1;i<=count;i++) {
			list.add(equipService.getData(i));
		
		}
		model.addAttribute("equipList",list);
		
		
		return "equip/equipList";
	}
	
	@GetMapping("/toEquipReturn")
	public String toEquipReturn(@RequestParam("user")String USERNAME,Model model) {
		
		
		RentVO vo=equipService.getRntlList(USERNAME);
		if(vo!=null) {
			model.addAttribute("vo",vo);			
			return "/equip/equipReturn";	
		}else {
			return "equip/equipClose";
		}
		
		
		
	}
	
	@GetMapping("/returnForm")
	public String returnForm(@RequestParam("rntlQty")int rntlQty,@RequestParam("rntlNo")int rntlNo,@RequestParam("istrCode")String code) {
	
		EquipVO vo1=equipService.getDetail(code);
		int istrqty=vo1.getISTR_QTY();
		vo1.setISTR_QTY(istrqty+rntlQty);
		equipService.updateIstr2(vo1);
		equipService.deleteRntl(rntlNo);
		
		return "equip/equipSucc";
	}
	
	@PostMapping("/rentRegForm")
	public String rentRegForm(RentVO vo) {
		String user=vo.getUSERNAME();
		int count=equipService.getRntlCount(user);
		if(count!=0) {
			return "equip/equipClose";
		}else {
			String rntName=vo.getISTR_NM();
			
			EquipVO vo2=equipService.getIstr(rntName);
			
			if(vo2.getISTR_QTY()<vo.getRNTL_QTY()) {
				return "equip/equipClose";
			}else {
				vo2.setISTR_QTY(vo2.getISTR_QTY()-vo.getRNTL_QTY());
				equipService.updateIstr(vo2);
				vo.setISTR_CODE(vo2.getISTR_CODE());
				equipService.rentReg(vo);
				return "equip/equipSucc";
			}
			
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
	
	@GetMapping("/detailPopup")
	public String popup(Model model,@RequestParam("code")String code) {
		
		EquipVO vo=equipService.getDetail(code);
		
		model.addAttribute("vo",vo);
		return "equip/equipDetail";
	}
	
	
	
	
	
}
