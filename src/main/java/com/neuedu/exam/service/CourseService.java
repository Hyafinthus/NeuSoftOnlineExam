package com.neuedu.exam.service;

import com.neuedu.exam.domain.Relation;

public interface CourseService {
	
	public void joinCourse(Relation relation);
	
	public void quitCourse(Relation relation);
	
	public void electiveCourse(Relation relation);
	
	public void withdrawCourse(Relation relation);
	
}
