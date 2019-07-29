package com.neuedu.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.TeacherCourse;
import com.neuedu.exam.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	@ResponseBody
	public String joinCourse(String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		TeacherCourse tc = new TeacherCourse(id, course_id);
		System.out.println(tc);
		
		courseService.joinCourse(tc);
		return "success";
	}
	
	@RequestMapping(value="/quit", method=RequestMethod.POST)
	@ResponseBody
	public String quitCourse(String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		TeacherCourse tc = new TeacherCourse(id, course_id);
		System.out.println(tc);
		
		courseService.quitCourse(tc);
		return "success";
	}
}
