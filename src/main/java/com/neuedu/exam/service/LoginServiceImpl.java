package com.neuedu.exam.service;

import com.neuedu.exam.dao.LoginMapper;
import com.neuedu.exam.domain.Teacher;

public class LoginServiceImpl implements LoginService {

	private LoginMapper loginMapper;
	
	@Override
	public Teacher teacherLogin(String teacherId) {
		return loginMapper.teacherLogin(teacherId);
	}

}
