package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.CourseMapper;
import com.neuedu.exam.domain.Notice;
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

	@Override
	public List<Relation> byCourse(Relation relation) {
		return courseMapper.byCourse(relation);
	}

	@Override
	public void sendNotice(Notice notice) {
		courseMapper.sendNotice(notice);
	}

}
