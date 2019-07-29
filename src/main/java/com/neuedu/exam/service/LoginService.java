package com.neuedu.exam.service;

import com.neuedu.exam.domain.User;

public interface LoginService {

	public User teacherLogin(User user);
	
	public User studentLogin(User user);
	
}
