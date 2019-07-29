package com.neuedu.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.User;

@Mapper
public interface LoginMapper {
	
	public User teacherLogin(User user);
	
	public User studentLogin(User user);
	
}
