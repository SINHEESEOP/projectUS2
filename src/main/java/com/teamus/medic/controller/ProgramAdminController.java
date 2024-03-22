	package com.teamus.medic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamus.medic.admin.service.adminService;
import com.teamus.medic.command.ProgramRegVO;
import com.teamus.medic.command.ProgramVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.command.adminVO;
import com.teamus.medic.program.service.ProgramService;
import com.teamus.medic.util.Criteria;
import com.teamus.medic.util.PageVO;

@Controller
@RequestMapping("admin/program")
public class ProgramAdminController {
	
	@Autowired
	@Qualifier("programService")
	private ProgramService programService;
	
	@Autowired
	private adminService adminservice; 
	
	
	@GetMapping("/main")
	public String main(Criteria cri , Model model) {
		
		List<ProgramRegVO> list = programService.getProgramApplyList(cri);
		List<adminVO> list2 = adminservice.getDscsnList();
		
		model.addAttribute("list",list);
		model.addAttribute("list2" , list2);
		
		return "admin/program/adminMain";
	}
	
	@GetMapping("/programReg")
	public String programReg() {
		
		return "admin/program/programReg";
	}
	
	@GetMapping("/programList")
	public String programList(Model model , Criteria cri) {
		
		List<ProgramVO> list = programService.getProgramList(cri);
		int total = programService.getProgramTotal();
		PageVO pageVO = new PageVO(cri, total);
		 
		model.addAttribute("list",list);
		model.addAttribute("pageVO", pageVO);
		
		System.out.println(pageVO.toString());
		
		return "admin/program/programList";
	}
	
	@GetMapping("/programApply")
	public String programApply(Model model, Criteria cri) {
		
		List<ProgramRegVO> list = programService.getProgramApplyList(cri);
		int total = programService.getProgramApplyTotal(cri);
		PageVO pageVO = new PageVO(cri , total);
		
		model.addAttribute("list",list);
		model.addAttribute("pageVO",pageVO);
		
		return "admin/program/programApply";
	}
	
	@GetMapping("/programDetail")
	public String programDetail(@RequestParam("EVNT_NO") int EVNT_NO , Model model) {
		
		ProgramVO vo = programService.getDetail(EVNT_NO);
		model.addAttribute("vo",vo);
		
		return "admin/program/programDetail";
	}
	
	@PostMapping("/programForm")
	public String programForm(ProgramVO vo) {
		
		int result = programService.programRegist(vo);
		
		if(result == 1) {
			return "redirect:/admin/program/programList";
		}else {
			return "redirect:/admin/program/programList";
		}
	}
	
	@PostMapping("/programUpdate")
	public String programUpdate(ProgramVO vo) {
		
		programService.programUpdate(vo);
		
		return "redirect:/admin/program/programList";
	}
	
	@GetMapping("/programDelete")
	public String programDelete(@RequestParam("EVNT_NO") int EVNT_NO) {
		
		programService.programDelete(EVNT_NO);
		programService.programApplydelete(EVNT_NO);
		
		return "redirect:/admin/program/programList";
	}
	
	@GetMapping("/applyUpdate")
	public String applyUpdate(@RequestParam("EVNT_REG_NO") int EVNT_REG_NO) {
		
		programService.applyUpdate(EVNT_REG_NO);
		
		return "redirect:/admin/program/programApply";
	}
	
	@GetMapping("/successUpdate")
	public String successUpdate(@RequestParam("EVNT_REG_NO") int EVNT_REG_NO) {
		
		programService.successUpdate(EVNT_REG_NO);
		
		return "redirect:/admin/program/programApply";
	}
}
