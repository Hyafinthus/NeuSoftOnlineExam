package com.neuedu.exam.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Message;
import com.neuedu.exam.domain.User;
import com.neuedu.exam.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminMenuController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String user_id, String user_password, HttpServletRequest request){
		User admin = adminService.adminLogin(new User(user_id, user_password));
		System.out.println(admin);
		if (admin != null) {
			System.out.println("控制器");
			HttpSession session = request.getSession();
			session.setAttribute("id", admin.getId());
			session.setAttribute("name", admin.getName());
			session.setAttribute("type", "admin");
			return "redirect:/adminmembers.html";
		} else {
			return "redirect:/adminlogin.html";
		}
	}
	
	@RequestMapping(value="/members", method=RequestMethod.GET)
	@ResponseBody
	public List<User> queryPersonal(){
		List<User> users = adminService.queryUsers();
		System.out.println(users);
		return users;
	}
	
	@RequestMapping(value = "/queryTeachers", method = RequestMethod.GET)
	@ResponseBody
	public List<User> queryTeachers(){
		List<User> users = adminService.queryTeachers();
		System.out.println(users);
		return users;
	}
	
	@RequestMapping(value = "/queryStudents", method = RequestMethod.GET)
	@ResponseBody
	public List<User> queryStudents(){
		List<User> users = adminService.queryStudents();
		System.out.println(users);
		return users;
	}
	
	@RequestMapping(value = "/deleteUser/{userid}", method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteStudent(@PathVariable String userid){
		adminService.deleteStudent(userid);
		return "success";
	}
	
	@RequestMapping(value = "/updatePassword/{userid}", method = RequestMethod.PUT)
	@ResponseBody
	public String updatePassword(@PathVariable String userid){
		adminService.updatePassword(userid);
		return "success";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestBody User user){
		User isExits = adminService.queryUserById(user.getId());
		System.out.println(isExits);
		if(isExits == null){
			adminService.addUser(user);
			return "success";
		}else
			return "false";
	}
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public String sendMessage(@RequestBody Message message, HttpServletRequest request){
		HttpSession session = request.getSession();
		String identity = message.getRecipientName();
		String addresserName = (String)session.getAttribute("name");
		String addresserId = (String)session.getAttribute("id");
		List<User> recipients = adminService.getRecipients(identity);
		String content = message.getContent();
		Date now=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		adminService.addMessage(addresserName,addresserId,recipients,content,sdf.format(now));
		if(recipients!=null)
			return "success";
		return "false";
		
	}
}
