package com.teamus.medic.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamus.medic.command.adminVO;


@Service("adminService")
public class adminServiceImpl implements adminService {

	
	@Autowired
	private AdminMapper adminMapper;
	
	
	@Override
	public ArrayList<adminVO> getDscsnList() {
		return adminMapper.getDscsnList();
	}


	@Override
	public adminVO getDetail(int DSCSN_SN) {
		
		return adminMapper.getDetail(DSCSN_SN);
	}


	@Override
	public void delete(int DSCSN_SN) {
		adminMapper.delete(DSCSN_SN);
	}
	
	public int DescsnUpdate (adminVO vo) {
		return adminMapper.DescsnUpdate(vo);
	}


	@Override
	public int insertDescsn(adminVO vo) {
		
		return adminMapper.insertDescsn(vo);
	}
	
}
