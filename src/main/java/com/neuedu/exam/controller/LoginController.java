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
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public String studentLogin(String student_id, String student_password, HttpServletRequest request) {
		User student = loginService.studentLogin(new User(student_id, student_password));
		System.out.println(student);
		
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
	
	@RequestMapping(value="/teacher", method=RequestMethod.POST)
	public String teacherLogin(String teacher_id, String teacher_password, HttpServletRequest request) {
		User teacher = loginService.teacherLogin(new User(teacher_id, teacher_password));
		System.out.println(teacher);
		
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
	
	
	
//	@RequestMapping(value="/getmessage")
//	@ResponseBody
//	public List<Message> teacherLogin() {
//		List<Message> messages = new ArrayList<Message>();
//		Message message1 = new Message("王忠杰", "万一鸣", "王忠杰，男，博士，教授，博士生导师，服务科学与工程系副主任。中国计算机学会会员、中国计算机学会青年计算机科学家论坛哈尔滨分论坛委员、黑龙江省软件行业协会专家委员会成员");
//		Message message2 = new Message("张炜", "万一鸣", "你算法挂了,微信联系我");
//		Message message3 = new Message("刘伟", "万一鸣", "你企业实训挂了,微信联系我");
//		Message message4 = new Message("苏小红", "万一鸣", "你C语言挂了,微信联系我");
//		Message message5 = new Message("张超", "万一鸣", "你微积分挂了,微信联系我");
//		Message message6 = new Message("战德臣", "万一鸣", "你大学计算机挂了,微信联系我");
//		
//		messages.add(message1);
//		messages.add(message2);
//		messages.add(message3);
//		messages.add(message4);
//		messages.add(message5);
//		messages.add(message6);
//		JSONArray json2 = JSONArray.fromObject(messages); //将java对象转换为json对象  
//        String str1 = json2.toString();
//        System.out.println(str1);
//        
//		return messages;
//	}
}
