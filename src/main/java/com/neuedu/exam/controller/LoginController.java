package com.neuedu.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Student;
import com.neuedu.exam.domain.Teacher;
import com.neuedu.exam.domain.User;
import com.neuedu.exam.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	@ResponseBody
	public String studentLogin(@RequestBody User user) {
		System.out.println("进入Controller: " + user);
		
		Student student = loginService.studentLogin(user);
		if (student != null) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping(value="/teacher", method=RequestMethod.POST)
	@ResponseBody
	public String teacherLogin(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入Controller: " + user);
		
		Teacher teacher = loginService.teacherLogin(user);
		if (teacher != null) {
			HttpSession session = request.getSession();
			session.setAttribute("teacher_id", teacher.getId());
			session.setAttribute("teacher_name", teacher.getName());
			return "success";
		} else {
			return "fail";
		}
	}
}
