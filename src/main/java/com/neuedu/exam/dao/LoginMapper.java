package com.neuedu.exam.dao;

import com.neuedu.exam.domain.Teacher;

public interface LoginMapper {
	
	public Teacher teacherLogin(String teacherId);
	
}
