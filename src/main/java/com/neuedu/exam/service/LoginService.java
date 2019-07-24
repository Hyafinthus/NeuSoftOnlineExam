package com.neuedu.exam.service;

import com.neuedu.exam.domain.Student;
import com.neuedu.exam.domain.Teacher;
import com.neuedu.exam.domain.User;

public interface LoginService {

	public Teacher teacherLogin(User user);
	
	public Student studentLogin(User user);
	
}
