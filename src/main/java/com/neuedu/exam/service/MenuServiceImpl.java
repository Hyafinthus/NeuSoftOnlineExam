package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.MenuMapper;
import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.User;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Course> getTeacherCourse(User user) {
		return menuMapper.getTeacherCourse(user);
	}

}
