package com.teamus.medic.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamus.medic.command.UserVO;

@Service("userService")
public class userServiceImpl implements userService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void join(UserVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO login(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
