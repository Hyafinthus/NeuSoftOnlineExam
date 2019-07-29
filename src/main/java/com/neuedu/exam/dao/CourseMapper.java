package com.neuedu.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Course;

@Mapper
public interface CourseMapper {
	
	public void addCourse(Course course);
	
}
