package com.neuedu.exam.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Notice;
import com.neuedu.exam.domain.Relation;
import com.neuedu.exam.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private CourseService courseService;
	
	// 老师加入课程
	@RequestMapping(value="/join", method=RequestMethod.POST)
	@ResponseBody
	public String joinCourse(String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(id, course_id);
		System.out.println("老师加入课程: " + relation);
		
		courseService.joinCourse(relation);
		return "success";
	}
	
	// 老师退出课程
	@RequestMapping(value="/quit", method=RequestMethod.POST)
	@ResponseBody
	public String quitCourse(String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(id, course_id);
		System.out.println("老师退出课程: " + relation);
		
		courseService.quitCourse(relation);
		return "success";
	}
	
	// 学生选课
	@RequestMapping(value="/elective", method=RequestMethod.POST)
	@ResponseBody
	public String electiveCourse(String teacher_id, String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(teacher_id, course_id, id, null);
		System.out.println("学生选课: " + relation);
		
		courseService.electiveCourse(relation);
		return "success";
	}
	
	// 学生退课
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	@ResponseBody
	public String withdrawCourse(String teacher_id, String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(teacher_id, course_id, id, null);
		System.out.println("学生退课: " + relation);
		
		courseService.withdrawCourse(relation);
		return "success";
	}
	
	// 老师查选课学生
	@RequestMapping(value="/by_course", method=RequestMethod.POST)
	@ResponseBody
	public List<Relation> byCourse(String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(id, course_id);
		System.out.println("老师查选课学生: " + relation);
		
		return courseService.byCourse(relation);
	}
	
	// 老师向选课学生发通知
	@RequestMapping(value="/notice", method=RequestMethod.POST)
	@ResponseBody
	public String sendNotice(String course_id, String notice_body, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		LocalDateTime today = LocalDateTime.now();

		Notice notice = new Notice(id, course_id, "student", notice_body, today.format(timeFmt));
		System.out.println("老师向选课学生发通知: " + notice);
		
		courseService.sendNotice(notice);
		return "success";
	}
}
