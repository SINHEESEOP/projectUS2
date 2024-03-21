package com.teamus.medic.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamus.medic.admin.service.adminService;
import com.teamus.medic.command.adminVO;


@Controller
@RequestMapping("admin")
public class adminController {

	@Autowired
	@Qualifier("adminService")
	private adminService adminService;
	
	@GetMapping("adminDscsnList")
	public String DscsnList(Model model) {
		
		ArrayList<adminVO> getDscsnList = adminService.getDscsnList();
		model.addAttribute("getDscsnList",getDscsnList);
		
		
		return "admin/adminDscsnList";
	}
	
	
	@GetMapping("dscsnDetail")
	public String ListDetail(@RequestParam("DSCSN_SN") int DSCSN_SN, Model model) {
		
		
		adminVO vo = adminService.getDetail(DSCSN_SN);
		
		
		model.addAttribute("vo", vo);
		
		
		
		return "admin/dscsnDetail";
	}
	
	
	@RequestMapping("/deleteForm")
	public String delete(@RequestParam("DSCSN_SN") int DSCSN_SN) {
		
		adminService.delete(DSCSN_SN);
		
		return "redirect:/admin/adminDscsnList";
	};
	
	
	
	@PostMapping("/updateForm")
	public String DescsnUpdate(adminVO vo,RedirectAttributes ra) {
		
		int result = adminService.DescsnUpdate(vo);
		
		
		if(result == 1 ) {
			
			ra.addFlashAttribute("msg", "수정되었습니다");
			
		}else {
			
			ra.addFlashAttribute("msg", "수정 실패했습니다");
		}
		
		
		
		
		
		return "redirect:/admin/adminDscsnList";
	}
	
	
	@GetMapping("dscsnInsert")
	public String insertPage() {
		
		return "admin/dscsnInsert";
	}
	
	
	@PostMapping("/insertForm")
	public String insertDescsn(adminVO vo,RedirectAttributes ra) {
		
		int result = adminService.insertDescsn(vo);
		
		if(result == 1) {
			ra.addFlashAttribute("msg2", "상담내역이 등록되었습니다");
		}else {
			
			ra.addFlashAttribute("msg2", "상담내역 등록에 실패했습니다.");
		}
		
		
		
		return "redirect:/admin/adminDscsnList";
	}
	
}

