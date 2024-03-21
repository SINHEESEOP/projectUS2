package com.teamus.medic.securlty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.teamus.medic.CustomRememberMeHandler;


@Configuration
@EnableWebSecurity
public class SecurltyConfig {

	@Autowired
	MyUserDetailsService myUserDetailService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		//시큐리티 폼으로 로그잉ㄴ
		
		http.formLogin()
			.loginPage("/LoginPageList")
			.loginProcessingUrl("/loginForm")
			.successHandler(authenticationSuccessHandler2())
			.failureHandler(customLoginFailureHandler())
			.and().exceptionHandling().accessDeniedPage("/deny")
			.and().logout().logoutUrl("/logoutForm").logoutSuccessUrl("/");
			
		
		
		http.rememberMe()
		.key("1234") //리멤버미를 쿠키로 동작시키는데 그때, 쿠키에 저장되는 토큰값을 만들 비밀키
		.tokenValiditySeconds(3600) //1시간 동안 유효한 토큰
		.rememberMeParameter("remember-me") //화면에서 전달되는 checkbox 파라미터 값
		.userDetailsService(myUserDetailService) //리멤버미 토큰이 있을때 실행시킬 로그인시도 서비스
		.authenticationSuccessHandler(authenticationSuccessHandler());
		
		//권한
		
	http.authorizeHttpRequests((authorize) -> authorize.antMatchers("/admin/**").hasRole("ADMIN")
														.antMatchers("/css/**").permitAll()
														.antMatchers("/js/**").permitAll()
														.antMatchers("/img/**").permitAll()
														 .anyRequest().permitAll());
		
			
		return http.build();
	}
	
	
	@Bean
	public CustomLoginFailureHandler customLoginFailureHandler() {
		return new CustomLoginFailureHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		
		return new CustomRememberMeHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler2() {
		
		return new CustomLoginHandler();
	}
	
}
