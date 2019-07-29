package com.neuedu.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Message;
import com.neuedu.exam.domain.User;
import com.neuedu.exam.service.LoginService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	@ResponseBody
	public String studentLogin(@RequestBody User user) {
		System.out.println("进入Controller: " + user);
		
		User student = loginService.studentLogin(user);
		if (student != null) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping(value="/teacher", method=RequestMethod.POST)
	public String teacherLogin(String teacher_id, String teacher_password, HttpServletRequest request) {
		//System.out.println("控制器");
		User teacher = loginService.teacherLogin(new User(teacher_id, teacher_password));
		System.out.println(teacher);
		if (teacher != null) {
			System.out.println("控制器");
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
	
	@RequestMapping(value="/getmessage")
	@ResponseBody
	public List<Message> teacherLogin() {
		List<Message> messages = new ArrayList<Message>();
		Message message1 = new Message("王忠杰", "万一鸣", "王忠杰，男，博士，教授，博士生导师，服务科学与工程系副主任。中国计算机学会会员、中国计算机学会青年计算机科学家论坛哈尔滨分论坛委员、黑龙江省软件行业协会专家委员会成员");
		Message message2 = new Message("张炜", "万一鸣", "你算法挂了,微信联系我");
		Message message3 = new Message("刘伟", "万一鸣", "你企业实训挂了,微信联系我");
		Message message4 = new Message("苏小红", "万一鸣", "你C语言挂了,微信联系我");
		Message message5 = new Message("张超", "万一鸣", "你微积分挂了,微信联系我");
		Message message6 = new Message("战德臣", "万一鸣", "你大学计算机挂了,微信联系我");
		
		messages.add(message1);
		messages.add(message2);
		messages.add(message3);
		messages.add(message4);
		messages.add(message5);
		messages.add(message6);
		JSONArray json2 = JSONArray.fromObject(messages); //将java对象转换为json对象  
        String str1 = json2.toString();
        System.out.println(str1);
        
		return messages;
	}
}
