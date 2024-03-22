package com.teamus.medic.User.service;

import org.apache.ibatis.annotations.Mapper;

import com.teamus.medic.command.UserVO;

@Mapper
public interface UserMapper {
	
	void join(UserVO vo);
	UserVO login(String username);
	
}
