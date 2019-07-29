package com.neuedu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.User;

@Mapper
public interface MenuMapper {

	public List<Course> getTeacherCourse(User user);
	
	public List<Course> getCourses(User user);
	
}
