package com.neuedu.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.User;

@Mapper
public interface PersonalMapper {
	
	public void modifyPassword(User user);
	
}
