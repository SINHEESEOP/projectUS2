package com.teamus.medic.securlty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teamus.medic.User.service.UserMapper;
import com.teamus.medic.command.UserVO;


@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		

		UserVO vo =  userMapper.login(username);	
		System.out.println(vo);
		
		if(vo != null) {
			
			return new MyUserDetails(vo);
		}
		
		return null;
	}
	

}
