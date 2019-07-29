package com.neuedu.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.TeacherCourse;

@Mapper
public interface CourseMapper {
	
	public void joinCourse(TeacherCourse tc);
	
	public void quitCourse(TeacherCourse tc);
	
}
