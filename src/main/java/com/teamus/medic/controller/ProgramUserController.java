package com.teamus.medic.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamus.medic.command.ProgramRegVO;
import com.teamus.medic.command.ProgramVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.program.service.ProgramService;
import com.teamus.medic.util.Criteria;
import com.teamus.medic.util.PageVO;

@Controller
@RequestMapping("user/program")
public class ProgramUserController {
	
	@Autowired
	private ProgramService programService;
	
	@GetMapping("/programUserList")
	public String programUserList(Model model, Criteria cri) {
		
		List<ProgramVO> list = programService.getProgramList(cri);
		int total = programService.getProgramTotal();
		PageVO pageVO = new PageVO(cri , total);
		
		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		
		return "user/program/programUserList";
	}
	
	@GetMapping("/programUserReg")
	public String programUserReg(@RequestParam("EVNT_NO") int EVNT_NO,
								 Principal principal,
								 Model model) {
		
		System.out.println(EVNT_NO);
		
		String USERNAME = principal.getName();
		
		System.out.println(USERNAME);
		
		UserVO user = programService.getUser(USERNAME);
		
		ProgramVO vo = programService.getDetail(EVNT_NO);
		model.addAttribute("vo",vo);
		model.addAttribute("user",user);
		
		return "/user/program/programUserReg";
	}
	
	@GetMapping("/programUserApply")
	public String programUserApply(Model model , Principal principal
								   ,Criteria cri) {
		//세션값으로 넘어와야함
		
		String USERNAME = principal.getName();
		
		List<ProgramRegVO> list = programService.getProgramRegList(USERNAME , cri);
		
		int total = programService.getUserApplyTotal(USERNAME);
		PageVO pageVO = new PageVO(cri,total);
		
		model.addAttribute("list",list);
		model.addAttribute("pageVO",pageVO);
		
		return "/user/program/programUserApply";
	}
	
	
	@PostMapping("/programUserForm")
	public String programUserForm(Principal principal,
						   @RequestParam("EVNT_NO") int EVNT_NO
						  ,UserVO vo
						  ) {
		
		String USERNAME = principal.getName();
		
		programService.programUserRegist(USERNAME,EVNT_NO);
		
		return "redirect:/user/program/programUserApply";
	}
	
	@GetMapping("/deleteApply")
	public String deleteApply(@RequestParam("EVNT_REG_NO") int EVNT_REG_NO
							 ,Principal principal) {
		
		String USERNAME = principal.getName();
		
		programService.deleteApply(EVNT_REG_NO);
		
		return "redirect:/user/program/programUserApply";
	}
	
	@GetMapping("/programUserDetail")
	public String programDetail(@RequestParam("EVNT_NO") int EVNT_NO , Model model) {
		
		ProgramVO vo = programService.getDetail(EVNT_NO);
		model.addAttribute("vo",vo);
		
		return "user/program/programUserDetail";
	}
}
