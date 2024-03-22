package com.teamus.medic.controller;

import com.teamus.medic.command.Pa_logVO;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.pa_log.service.Pa_logService;
import com.teamus.medic.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@RequestMapping("/admin/pa_log")
@Controller
public class Pa_logController {

	@Autowired
	@Qualifier("Pa_logService")
	private Pa_logService paLogService;

	@GetMapping("/pa_logDetail")
	private String Detail() {
		return "admin/pa_log/pa_logDetail";
	}

	@PostMapping("/logDetailForm")
	private String logDetailForm(Pa_logVO vo, Model model) {

		System.out.println(vo.getMDEXM_BNO() );

		UserVO userVO = paLogService.getUser(vo.getUSERNAME() );
		Pa_logVO paLogVO = paLogService.getDetailPaLog(vo.getMDEXM_BNO() );

		model.addAttribute("userVo", userVO);
		model.addAttribute("paLogVO", paLogVO);

		return "admin/pa_log/pa_logDetail";
	}

	// 진단목록 확인 페이지.
	@GetMapping("/pa_logList")
	public String list(Model model) {

		UserVO userVo = new UserVO();
		model.addAttribute("userVo",userVo);

		return "admin/pa_log/pa_logList";
	}

	@GetMapping("/popupList")
	public String popuplist(Model model,
	                        @RequestParam(name = "query", required = false) String query,
	                        Search search) {

		Pa_logVO paLogVO = new Pa_logVO();
		model.addAttribute("paLogVO", paLogVO);

		// 유저정보 자동입력.
		UserVO userVo = paLogService.getUser(query);
		model.addAttribute("userVo", userVo);

		// 사용자 번호로 진료내역 가지고옴
		ArrayList<Pa_logVO> listPaLog = paLogService.getListPaLog(query);
		model.addAttribute("listPaLog", listPaLog);

		return "admin/pa_log/pa_logList";
	}

	@GetMapping("/popup")
	public String popup(Model model, Search search) {

		ArrayList<UserVO> listPop = paLogService.getListPop(search);
		UserVO vo = new UserVO(search);
		model.addAttribute("listPop", listPop);
		model.addAttribute("vo", vo);

		return "admin/pa_log/popup";
	}

	// 진단서 작성 페이지.
	@PostMapping("/pa_logReg")
	public String reg(Pa_logVO vo, Model model, RedirectAttributes ra) {

		System.out.println(vo.toString());

		// 유저정보 자동입력.
		UserVO userVo = paLogService.getUser(vo.getUSERNAME());
		model.addAttribute("userVo", userVo);

		// 진단서 인설트.
		int result = paLogService.logInsert(vo);
		if(result == 1) { // 성공
			ra.addFlashAttribute("msg", "정상적으로 처리되었습니다.");
		} else { // 실패
			ra.addFlashAttribute("msg", "등록에 실패했습니다. 관리자에게 문의하세요. 1566-9000");
		}

		// 사용자 번호로 진료내역 가지고옴
		ArrayList<Pa_logVO> listPaLog = paLogService.getListPaLog(vo.getUSERNAME());
		model.addAttribute("listPaLog", listPaLog);

		return "admin/pa_log/pa_logList";
	}

	// 진단서 등록요청.
	@PostMapping("/pa_logForm")
	public String pa_logForm(Pa_logVO vo, RedirectAttributes ra) {

		System.out.println(vo.toString() );

		int result = paLogService.regist(vo);
		if(result == 1) { // 성공
			ra.addFlashAttribute("msg", "정상적으로 처리되었습니다.");
		} else { // 실패
			ra.addFlashAttribute("msg", "등록에 실패했습니다. 관리자에게 문의하세요. 1566-9000");
		}

		// 데이터를 가지고 다른 화면으로 넘어가는 것이 아니기 때문에 redirect 를 사용하여 페이지 이동.
		return "redirect:/admin/pa_log/pa_logList";
	}



}