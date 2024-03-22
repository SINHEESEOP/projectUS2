package com.teamus.medic.User.service;


import com.teamus.medic.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

public class userService {
	
	
	void join(UserVO vo);
	UserVO login(String username);
	
}
