package com.neuedu.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.TeacherCourse;

@Mapper
public interface CourseMapper {
	
	public void addCourse(Course course);
	
	public void addTchCrs(TeacherCourse tc);
	
	public Course existCourse(Course course);
	
}
