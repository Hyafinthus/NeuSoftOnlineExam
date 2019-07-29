package com.neuedu.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.TeacherCourse;
import com.neuedu.exam.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String addCourse(String course_id, String course_name, String course_intro, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(course_id + course_name + course_intro);
		
		Course course = new Course(course_id, course_name, course_intro);
		String id = (String) request.getSession().getAttribute("id");
		TeacherCourse tc = new TeacherCourse(course_id, id);
		
		System.out.println(course + " " + tc);
		
		courseService.addCourse(course, tc);
		return "success";
	}
	
}
