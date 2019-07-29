package com.neuedu.exam.service;

import com.neuedu.exam.domain.TeacherCourse;

public interface CourseService {
	
	public void joinCourse(TeacherCourse tc);
	
	public void quitCourse(TeacherCourse tc);
	
}
