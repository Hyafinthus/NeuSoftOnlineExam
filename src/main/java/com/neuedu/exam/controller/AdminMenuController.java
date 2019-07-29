package com.neuedu.exam.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.User;
import com.neuedu.exam.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminMenuController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/members", method=RequestMethod.GET)
	@ResponseBody
	public List<User> queryPersonal(){
		List<User> users=adminService.queryUsers();
		System.out.println(users);
		return users;
	}
	
	@RequestMapping(value="/queryTeachers", method=RequestMethod.GET)
	@ResponseBody
	public List<User> queryTeachers(){
		List<User> users=adminService.queryTeachers();
		System.out.println(users);
		return users;
	}
	
	@RequestMapping(value="/queryStudents", method=RequestMethod.GET)
	@ResponseBody
	public List<User> queryStudents(){
		List<User> users=adminService.queryStudents();
		System.out.println(users);
		return users;
	}
	
	@RequestMapping(value="/deleteUser/{userid}", method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteStudent(@PathVariable String userid){
		adminService.deleteStudent(userid);
		return "success";
	}
	
	@RequestMapping(value="/updatePassword/{userid}", method=RequestMethod.PUT)
	@ResponseBody
	public String updatePassword(@PathVariable String userid){
		adminService.updatePassword(userid);
		return "success";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestBody User user){
		User isExits=adminService.queryUserById(user.getId());
		System.out.println(isExits);
		if(isExits==null){
			adminService.addUser(user);
			return "success";
		}else
			return "false";
	}
	
	@RequestMapping(value="/queryQuestionIds", method=RequestMethod.GET)
	@ResponseBody
	public int[] queryQuestionIds(){
		int[] test = adminService.queryQuestionIds();
		return test;
	}
	
	@RequestMapping(value="/queryCourseName/{questionid}", method=RequestMethod.GET)
	@ResponseBody
	public String queryCourseNameByQuestionId(@PathVariable String questionid){
		return adminService.queryCourseNameByQuestionId(questionid);
	}
	
	@RequestMapping(value="/queryTeacherName/{questionid}", method=RequestMethod.GET)
	@ResponseBody
	public String queryTeacherNameByQuestionId(@PathVariable String questionid){
		return adminService.queryTeacherNameByQuestionId(questionid);
	}
}
