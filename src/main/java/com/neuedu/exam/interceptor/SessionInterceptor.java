package com.neuedu.exam.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class SessionInterceptor implements HandlerInterceptor {

	private static List<String> teacher = Arrays.asList(
			"/login/teacher",
			
			"/menu/personal", "/menu/teacher_course", "/menu/teacher_candidate",
			"/menu/question", "/menu/teacher/exam", "/menu/student", "/menu/notice",
			
			"/personal/modify",
			
			"/course/join", "/course/quit", "/course/by_course", "/course/notice",
			
			"/question/add", "/question/del", "/question/by_course",
			"/question/query", "/question/modify",
			
			"/exam/add", "/exam/review", "/exam/confirm",
			
			"/teachermenu.html", "/choosecourse.html", "/coursemanagement.html",
			"/exammanagement.html", "/questionsmanagement.html", "/studentlist.html",
			"/teachermessage.html",
			
			"/addcourse.html", "/addexam.html", "/addquestion.html", "/infomod.html", 
			"/modifyquestion.html", "/paperinspection.html"
			);
	
	private static List<String> student = Arrays.asList(
			"/login/student",
			
			"/menu/personal", "/menu/student_course", "/menu/student_candidate",
			"/menu/student/exam", "/menu/student/score", "/menu/notice",
			
			"/personal/modify",
			
			"/course/elective", "/course/withdraw",
			
			"/exam/start", "/exam/end", "/exam/question", "/exam/submit", "/exam/detail",
			
			"/studentmenu.html", "/elective.html", "/examtobedone.html",
			"/getmessage.html", "/stuquitcourse.html", "/infomod.html",
			"/examination.html", "/examhistory.html", "/examresult.html"
			);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("进入PreHandle: " + request.getRequestURI());
		String path = request.getServletPath();
		if(path.contains("session")) {
			path = path.split(";")[0];
		}
		
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type == null) {
			System.err.println("拦截: 未登录");
			response.sendRedirect("/exam/index.html");
			return false;
		}
		
		switch (type) {
			case "admin":
				if(path.contains("admin")) {
					return true;
				} else {
					System.err.println("拦截: admin越权");
					return false;
				}
			case "teacher":
				if(teacher.contains(path)) {
					return true;
				} else {
					System.err.println("拦截: teacher越权");
					response.sendRedirect("/exam/teachermenu.html");
					return false;
				}
			case "student":
				if(student.contains(path)) {
					return true;
				} else {
					System.err.println("拦截: student越权");
					response.sendRedirect("/exam/studentmenu.html");
					return false;
				}
			default:
				return false;
		}
	}

}
