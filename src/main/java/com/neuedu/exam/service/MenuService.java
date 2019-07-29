package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.User;

public interface MenuService {
	
	public List<Course> getTeacherCourse(User user);
	
	public List<Course> getCourses(User user);
	
}
