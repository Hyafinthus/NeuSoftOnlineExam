package com.neuedu.exam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Question;
import com.neuedu.exam.domain.Relation;
import com.neuedu.exam.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	// 老师增加题目
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String addQuestion(@RequestBody Question question, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		question.setTeacher_id(id);
		System.out.println("老师增加题目: " + question);
		
		questionService.addQuestion(question);
		return "success";
	}
	
	// 老师删除题目
	@RequestMapping(value="/del", method=RequestMethod.POST)
	@ResponseBody
	public String delQuestion(String question_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(id, null, question_id);
		System.out.println("老师删除题目: " + relation);
		
		questionService.delQuestion(relation);		
		return "success";
	}
	
	// 老师按科目查看题目
	@RequestMapping(value="/by_course", method=RequestMethod.POST)
	@ResponseBody
	public List<Question> byCourse(String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(id, course_id);
		System.out.println("老师按科目查看题目: " + relation);
		
		return questionService.byCourse(relation);
	}
	
	// 老师查看题目详情
	@RequestMapping(value="/query", method=RequestMethod.POST)
	@ResponseBody
	public Question queryQuestion(String question_id, HttpServletRequest request, HttpServletResponse response) {
		Question question = questionService.queryQuestion(question_id);
		System.out.println("老师查看题目详情: " + question);
		
		return question;
	}
	
	// 老师修改题目
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	@ResponseBody
	public String modifyQuestion(@RequestBody Question question, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("老师修改题目: " + question);
		
		questionService.modifyQuestion(question);
		return "success";
	}
}
