package com.teamus.medic.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamus.medic.User.service.UserMapper;
import com.teamus.medic.User.service.userService;
import com.teamus.medic.command.UserVO;
import com.teamus.medic.securlty.MyUserDetails;


@Controller
public class MainController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserMapper userMapper;

	@GetMapping("/")
	public String main(Authentication auth) {

		if(auth != null) {
			MyUserDetails details = (MyUserDetails)auth.getPrincipal();

			String username  = details.getUsername();
			String password = details.getPassword();
			String role = details.getRole();

		}

		return "main";
	}

	@GetMapping("/LoginPageList")
	public String LoginPageList() {



		return "LoginPageList";
	}

	 @GetMapping("/adminLoginPage")
	 public String adminLogin(@RequestParam(value = "err", required = false) String err, Model model) {

		 if(err != null) {
				model.addAttribute("mgs"," ※ 아이디 또는 비밀번호를 확인하세요");

			}


		 return "adminLoginPage";
	 }


	 @GetMapping("/UserLoginPage")
	 public String userLogin(@RequestParam(value = "err", required = false) String err, Model model) {

		if(err != null) {
			model.addAttribute("mgs","※ 아이디 또는 비밀번호를 확인하세요");

		}

		 return "UserLoginPage";
	 }


	 @GetMapping("/join")
	 public String join() {

		 return "join";
	 }





	 @PostMapping("/joinForm")
	 public String joinForm(UserVO vo) {

		 String pw = bCryptPasswordEncoder.encode(vo.getPASSWORD());

		 vo.setPASSWORD(pw);

		 userMapper.join(vo);


		 return "redirect:/LoginPageList";
	 }
	 
	 @GetMapping("/myPage")
	 public String myPage (Principal principal,Model model) {
		 
		String username =  principal.getName();
		UserVO vo =  userMapper.login(username);
		 
		 
		 
		 model.addAttribute("vo",vo);
		 
		 return "/myPage";
		 
	 }
	 
	 @PostMapping("/updateForm")
	 public String updateForm(UserVO vo) {
		 
		
		 userMapper.updateForm(vo);
		 
		 
		 return "redirect:/";
	 }
	 
	
	 @GetMapping("/deny")
	 public @ResponseBody String deny() {

		 return "권한이 없는 페이지입니다.";
	 }

  
  
}
