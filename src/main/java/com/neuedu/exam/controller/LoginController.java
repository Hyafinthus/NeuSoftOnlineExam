package com.neuedu.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.exam.domain.User;
import com.neuedu.exam.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	// 学生登陆
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public String studentLogin(String student_id, String student_password, HttpServletRequest request) {
		User student = loginService.studentLogin(new User(student_id, student_password));
		System.out.println("Student: " + student);
		
		if (student != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", student.getId());
			session.setAttribute("name", student.getName());
			session.setAttribute("password", student.getPassword());
			session.setAttribute("type", "student");
			return "redirect:/studentmenu.html";
		} else {
			return "redirect:/studentlogin.html";
		}
	}
	
	// 老师登陆
	@RequestMapping(value="/teacher", method=RequestMethod.POST)
	public String teacherLogin(String teacher_id, String teacher_password, HttpServletRequest request) {
		User teacher = loginService.teacherLogin(new User(teacher_id, teacher_password));
		System.out.println("Teacher: " + teacher);
		
		if (teacher != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", teacher.getId());
			session.setAttribute("name", teacher.getName());
			session.setAttribute("password", teacher.getPassword());
			session.setAttribute("type", "teacher");
			return "redirect:/teachermenu.html";
		} else {
			return "redirect:/teacherlogin.html";
		}
	}
	
}
