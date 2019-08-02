package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.AdminCourseMapper;
import com.neuedu.exam.domain.Course;

@Service
public class AdminCourseServiceImpl implements AdminCourseService {

	@Autowired
	private AdminCourseMapper adminCourseMapper;
	
	@Override
	public List<Course> queryCourses() {
		return adminCourseMapper.queryCourses();
	}

	@Override
	public String getCourseIntro(String courseId) {
		return adminCourseMapper.getCourseIntro(courseId);
	}

	@Override
	public void deleteCourse(String courseId) {
		adminCourseMapper.deleteCourse(courseId);
	}

	@Override
	public Course queryCourseByName(String courseName) {
		return adminCourseMapper.queryCourseByName(courseName);
	}

	@Override
	public void addCourse(Course course) {
		adminCourseMapper.addCourse(course);
	}

	@Override
	public Course queryCourseById(String courseId) {
		return adminCourseMapper.queryCourseById(courseId);
	}

}
