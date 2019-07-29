package com.neuedu.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.CourseMapper;
import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.TeacherCourse;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public void addCourse(Course course, TeacherCourse tc) {
		courseMapper.addCourse(course);
		courseMapper.addTchCrs(tc);
	}

	@Override
	public Course existCourse(Course course) {
		return courseMapper.existCourse(course);
	}

}
