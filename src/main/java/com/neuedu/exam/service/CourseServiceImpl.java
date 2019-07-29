package com.neuedu.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.CourseMapper;
import com.neuedu.exam.domain.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public void addCourse(Course course) {
		courseMapper.addCourse(course);
	}

}
