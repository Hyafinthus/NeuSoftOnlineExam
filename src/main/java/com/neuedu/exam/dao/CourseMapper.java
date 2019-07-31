package com.neuedu.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Relation;

@Mapper
public interface CourseMapper {
	
	public void joinCourse(Relation relation);
	
	public void quitCourse(Relation relation);
	
	public void electiveCourse(Relation relation);
	
	public void withdrawCourse(Relation relation);
	
}
