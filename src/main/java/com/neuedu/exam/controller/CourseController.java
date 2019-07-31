package com.neuedu.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Relation;
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
		Relation relation = new Relation(id, course_id);
		System.out.println(relation);
		
		courseService.joinCourse(relation);
		return "success";
	}
	
	@RequestMapping(value="/quit", method=RequestMethod.POST)
	@ResponseBody
	public String quitCourse(String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(id, course_id);
		System.out.println(relation);
		
		courseService.quitCourse(relation);
		return "success";
	}
	
	@RequestMapping(value="/elective", method=RequestMethod.POST)
	@ResponseBody
	public String electiveCourse(String teacher_id, String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(teacher_id, course_id, id, null);
		System.out.println(relation);
		
		courseService.electiveCourse(relation);
		return "success";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	@ResponseBody
	public String withdrawCourse(String teacher_id, String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(teacher_id, course_id, id, null);
		System.out.println(relation);
		
		courseService.withdrawCourse(relation);
		return "success";
	}
}
