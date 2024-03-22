package com.teamus.medic.securlty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		
		String role = ((MyUserDetails)authentication.getPrincipal() ).getRole();
		
		String username = ((MyUserDetails)authentication.getPrincipal() ).getUsername();
		
		
		
	if(role.equals("ROLE_USER")) {
		 response.sendRedirect("/");
	}else {
		response.sendRedirect("/admin/program/main");
	}
	
		
		
//		List<String> roleNames = new ArrayList<>();
//		
//		authentication.getAuthorities().forEach(authority -> {
//			System.out.println(authority.getAuthority());
//			roleNames.add(authority.getAuthority());
//		});
//
//		System.out.println(roleNames.toString());
////		if(roleNames.contains("ROLE_USER")) {
////			response.sendRedirect("/ASDSADSADSADSA");
////			return;
////		}
////		else {
////			response.sendRedirect("/sample/member1231232");
////			return;
////		}
//	
		
		System.out.println(authentication);  
		System.out.println(authentication.getPrincipal()  );
		System.out.println( ((MyUserDetails)authentication.getPrincipal() ).getRole() );
		
		
//	     List<GrantedAuthority> authList = (List<GrantedAuthority>) authentication.getAuthorities();
//	        System.out.println("권한: ");
//	        for(int i=0; i<authList.size(); i++){
//	        	System.out.println(authList.get(i).getAuthority() + " ");
//	        }
		
		
		
		
	}

}
