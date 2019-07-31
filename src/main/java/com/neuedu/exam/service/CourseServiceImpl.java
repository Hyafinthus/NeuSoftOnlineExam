package com.neuedu.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.CourseMapper;
import com.neuedu.exam.domain.Relation;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;

	@Override
	public void joinCourse(Relation relation) {
		courseMapper.joinCourse(relation);
	}

	@Override
	public void quitCourse(Relation relation) {
		courseMapper.quitCourse(relation);
	}

	@Override
	public void electiveCourse(Relation relation) {
		courseMapper.electiveCourse(relation);
	}

	@Override
	public void withdrawCourse(Relation relation) {
		courseMapper.withdrawCourse(relation);
	}

}
