package com.neuedu.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Teacher;
import com.neuedu.exam.domain.User;

@Mapper
public interface LoginMapper {
	
	public Teacher teacherLogin(User user);
	
}
