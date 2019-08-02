package com.neuedu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Course;

@Mapper
public interface AdminCourseMapper {

	public List<Course> queryCourses();

	public String getCourseIntro(String courseId);

	public void deleteCourse(String courseId);

	public Course queryCourseByName(String courseName);

	public void addCourse(Course course);

	public Course queryCourseById(String courseId);

}
