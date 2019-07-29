package com.neuedu.exam.service;

import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.TeacherCourse;

public interface CourseService {
	
	public Course existCourse(Course course);
	
	public void addCourse(Course course, TeacherCourse tc);
	
}
