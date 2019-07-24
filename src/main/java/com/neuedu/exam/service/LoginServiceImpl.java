package com.neuedu.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.LoginMapper;
import com.neuedu.exam.domain.Student;
import com.neuedu.exam.domain.Teacher;
import com.neuedu.exam.domain.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public Teacher teacherLogin(User user) {
		return loginMapper.teacherLogin(user);
	}

	@Override
	public Student studentLogin(User user) {
		return loginMapper.studentLogin(user);
	}

}
