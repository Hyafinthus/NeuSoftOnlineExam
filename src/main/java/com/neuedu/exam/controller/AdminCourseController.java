package com.neuedu.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Course;
import com.neuedu.exam.service.AdminCourseService;

@Controller
@RequestMapping("/admin/course")
public class AdminCourseController {
	
	@Autowired
	private AdminCourseService adminCourseService;
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public List<Course> queryCourses(){
		return adminCourseService.queryCourses();
	}
	
	@RequestMapping(value="/intro/{courseid}",method=RequestMethod.GET)
	@ResponseBody
	public String getCourseIntro(@PathVariable String courseid){
		System.out.println(courseid);
		return adminCourseService.getCourseIntro(Integer.parseInt(courseid));
	}
	
	@RequestMapping(value="/delete/{courseid}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteCourse(@PathVariable String courseid){
		adminCourseService.deleteCourse(Integer.parseInt(courseid));
		return "success";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public String addCourse(@RequestBody Course course){
		Course isExits=adminCourseService.queryCourseByName(course.getCourse_name());
		System.out.println(isExits);
		if(isExits==null){
			adminCourseService.addCourse(course);
			return "success";
		}else
			return "false";
	}
}
