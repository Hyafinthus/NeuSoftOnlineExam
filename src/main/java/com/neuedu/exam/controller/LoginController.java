package com.neuedu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.exam.domain.Teacher;
import com.neuedu.exam.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/student")
	public String studentLogin() {
		
		return "";
	}
	
	@RequestMapping("/teacher")
	public String teacherLogin(@RequestParam("teacher_id") String teacherId) {
		Teacher teacher = loginService.teacherLogin(teacherId);
		if (teacher != null) {
			return "teachermenu";
		} else {
			return "fail";
		}
	}
}
