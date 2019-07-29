package com.neuedu.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.User;
import com.neuedu.exam.service.PersonalService;

@Controller
@RequestMapping("/personal")
public class PersonalController {
	
	@Autowired
	private PersonalService personalService;

	@RequestMapping(value="/modify", method=RequestMethod.POST)
	@ResponseBody
	public String modifyPassword(String oldpwd, String newpwd, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(oldpwd + newpwd);
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String password = (String) session.getAttribute("password");
		
		if(oldpwd.equals(password)) {
			if(newpwd.equals(password)) {
				return "same";
			}
			User newUser = new User(id, newpwd);
			
			System.out.println(newUser);
			
			personalService.modifyPassword(newUser);
			session.invalidate();
			return "success";
		} else {
			return "fail";
		}
	}
	
}
