package com.teamus.medic.securlty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		
		 String url = request.getParameter("url");
		 System.out.println("로그인실패: 요청경로 - " + url);
		
		 
		 response.sendRedirect( request.getContextPath() + url + "?err=true" );
		 
		
	}

}
