package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.Course;

public interface AdminCourseService {

	public List<Course> queryCourses();

	public String getCourseIntro(Integer courseId);

	public void deleteCourse(int courseId);

	public Course queryCourseByName(String courseName);

	public void addCourse(Course course);

	public Course queryCourseById(String courseId);

}
