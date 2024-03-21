package com.teamus.medic.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class userServiceImpl implements userService {
	
	@Autowired
	private UserMapper userMapper;
	
}
