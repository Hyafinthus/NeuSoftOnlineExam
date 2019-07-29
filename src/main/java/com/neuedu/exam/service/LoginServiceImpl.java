package com.neuedu.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.LoginMapper;
import com.neuedu.exam.domain.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public User teacherLogin(User user) {
		return loginMapper.teacherLogin(user);
	}

	@Override
	public User studentLogin(User user) {
		return loginMapper.studentLogin(user);
	}

}
