package com.teamus.medic.User.service;

import com.teamus.medic.command.UserVO;

public interface userService {
	
	void join(UserVO vo);
	UserVO login(String username);
	

}
