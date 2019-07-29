package com.neuedu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Course;
import com.neuedu.exam.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String addCourse(String course_name, String course_intro) {
		System.out.println(course_name + course_intro);
		
		Course course = new Course(course_name, course_intro);
		courseService.addCourse(course);
		
		return "success";
	}
	
}
