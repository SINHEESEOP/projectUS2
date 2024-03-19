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

import com.teamus.medic.command.ProgramRegVO;
import com.teamus.medic.command.ProgramVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.program.service.ProgramService;

@Controller
@RequestMapping("/program")
public class ProgramController {
	
	@Autowired
	@Qualifier("programService")
	private ProgramService programService;
	
	@GetMapping("/programReg")
	public String programReg() {
		
		return "admin/program/programReg";
	}
	
	@GetMapping("/programList")
	public String programList(Model model) {
		
		List<ProgramVO> list = programService.getProgramList();
		
		model.addAttribute("list",list);
		
		return "admin/program/programList";
	}
	
	@GetMapping("/programApply")
	public String programApply(Model model) {
		
		List<ProgramRegVO> list = programService.getProgramApplyList();
		model.addAttribute("list",list);
		
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
			return "redirect:/program/programList";
		}else {
			return "admin/program/programReg";
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
		
		return "redirect:/admin/program/programList";
	}
	
	@GetMapping("/programUserList")
	public String programUserList(Model model) {
		
		List<ProgramVO> list = programService.getProgramList();
		
		model.addAttribute("list", list);
		
		return "/user/program/programUserList";
	}
	
	@GetMapping("/programUserReg")
	public String programUserReg(@RequestParam("EVNT_NO") int EVNT_NO,
								 @RequestParam("USER_NO") String USER_NO
								 ,Model model) {
		
		System.out.println(EVNT_NO);
		System.out.println(USER_NO);
		
		UserVO user = programService.getUser(USER_NO);
		
		ProgramVO vo = programService.getDetail(EVNT_NO);
		model.addAttribute("vo",vo);
		model.addAttribute("user",user);
		
		return "/user/program/programUserReg";
	}
	
	@GetMapping("/programUserApply")
	public String programUserApply(Model model) {
		
		List<ProgramRegVO> list = programService.getProgramRegList();
		model.addAttribute("list",list);
		
		return "/user/program/programUserApply";
	}
	
	
	@PostMapping("/programUserForm")
	public String programUserForm(@RequestParam("USER_NO") String USER_NO,
						   @RequestParam("EVNT_NO") int EVNT_NO
						  ,UserVO vo) {
		
		programService.programUserRegist(USER_NO,EVNT_NO);
		
		return "redirect:/program/programUserApply";
	}
	
	@GetMapping("/deleteApply")
	public String deleteApply(@RequestParam("EVNT_REG_NO") int EVNT_REG_NO) {
		
		programService.deleteApply(EVNT_REG_NO);
		
		return "redirect:/program/programUserApply";
	}
	
	@GetMapping("/applyUpdate")
	public String applyUpdate(@RequestParam("EVNT_REG_NO") int EVNT_REG_NO) {
		
		programService.applyUpdate(EVNT_REG_NO);
		
		return "redirect:/program/programApply";
	}
	
	@GetMapping("/successUpdate")
	public String successUpdate(@RequestParam("EVNT_NO") int EVNT_NO) {
		
		programService.successUpdate(EVNT_NO);
		
		return "redirect:/program/programApply";
	}
}
