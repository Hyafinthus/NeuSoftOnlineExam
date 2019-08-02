package com.neuedu.exam.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.Exam;
import com.neuedu.exam.domain.ExamPaper;
import com.neuedu.exam.domain.Notice;
import com.neuedu.exam.domain.Question;
import com.neuedu.exam.domain.Relation;
import com.neuedu.exam.domain.User;
import com.neuedu.exam.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	// 个人信息
	@RequestMapping(value="/personal")
	@ResponseBody
	public List<String> getPersonal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		return Arrays.asList(id, name);
	}

	// 老师已加入课程
	@RequestMapping(value="/teacher_course")
	@ResponseBody
	public List<Course> getTeacherCourse(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		User user = new User(id);
		
		List<Course> list = menuService.getTeacherCourse(user);
		System.out.println("老师已加入课程: " + list);
		return list;
	}
	
	// 老师未加入课程
	@RequestMapping(value="/teacher_candidate")
	@ResponseBody
	public List<Course> getTeacherCandidate(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		User user = new User(id);
		
		List<Course> list = menuService.getTeacherCandidate(user);
		System.out.println("老师未加入课程: " + list);
		return list;
	}
	
	// 老师出的题
	@RequestMapping(value="/question")
	@ResponseBody
	public List<Question> getQuestion(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		User user = new User(id);
		
		List<Question> list = menuService.getQuestion(user);
		System.out.println("老师出的题: " + list);
		return list;
	}
	
	// 老师安排的考试
	@RequestMapping("/teacher/exam")
	@ResponseBody
	public List<Exam> getExam(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		User user = new User(id);
		
		List<Exam> list = menuService.getExam(user);
		System.out.println("老师安排的考试: " + list);
		return list;
	}
	
	// 学生已加入课程
	@RequestMapping("/student_course")
	@ResponseBody
	public List<Relation> getStudentCourse(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		User user = new User(id);
		
		List<Relation> list = menuService.getStudentCourse(user);
		System.out.println("学生已加入课程: " + list);
		return list;
	}
	
	// 学生未加入课程
	@RequestMapping("/student_candidate")
	@ResponseBody
	public List<Relation> getStudentCandidate(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		User user = new User(id);
		
		List<Relation> list = menuService.getStudentCandidate(user);
		System.out.println("学生未加入课程: " + list);
		return list;
	}
	
	// 学生待参加的考试
	@RequestMapping("/student/exam")
	@ResponseBody
	public List<Exam> getStudentExam(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		User user = new User(id);
		
		LocalDateTime today = LocalDateTime.now();
		
		List<Exam> list = menuService.getStudentExam(user);
		System.out.println("判断前考试列表: " + list);
		
		Iterator<Exam> iterator = list.iterator();
		while(iterator.hasNext()) {
			Exam exam = iterator.next();
			LocalDateTime end_time = LocalDateTime.parse(exam.getExam_time_end(), timeFmt);
			if(today.isAfter(end_time)) {
				iterator.remove();
			}
		}
		
		System.out.println("学生待参加的考试: " + list);
		return list;
	}
	
	
	// 学生已批改考试的成绩
	@RequestMapping("/student/score")
	@ResponseBody
	public List<ExamPaper> getStudentScore(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		User user = new User(id);
		
		List<ExamPaper> list = menuService.getStudentScore(user);
		System.out.println("学生已批改考试的成绩: " + list);
		return list;
	}
	
	// 老师查看选课学生
	@RequestMapping("/student")
	@ResponseBody
	public List<Relation> getStudent(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		User user = new User(id);
		
		List<Relation> list = menuService.getStudent(user);
		System.out.println("老师查看选课学生: " + list);
		return list;
	}
	
	// 显示消息列表
	@RequestMapping("/notice")
	@ResponseBody
	public List<Notice> getNotice(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String type = (String) session.getAttribute("type");
		User user = new User(id, null, type);
		
		List<Notice> list = menuService.getNotice(user);
		System.out.println("显示消息列表: " + list);
		return list;
	}
	
}
