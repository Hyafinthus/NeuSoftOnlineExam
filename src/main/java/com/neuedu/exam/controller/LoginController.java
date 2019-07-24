package com.neuedu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Teacher;
import com.neuedu.exam.domain.User;
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
	
	@RequestMapping(value="/teacher", method=RequestMethod.POST)
	@ResponseBody
	public String teacherLogin(@RequestBody User user) {
		System.out.println("进入controller");
		System.out.println(user);
		Teacher teacher = loginService.teacherLogin(user);
		if (teacher != null) {
			return "success";
		} else {
			return "fail";
		}
	}
}
