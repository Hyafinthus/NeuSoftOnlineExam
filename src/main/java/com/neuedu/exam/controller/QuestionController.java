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
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String addQuestion(@RequestBody Question question, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		question.setTeacher_id(id);
		System.out.println(question);
		
		questionService.addQuestion(question);
		return "success";
	}
	
	@RequestMapping(value="/del", method=RequestMethod.POST)
	@ResponseBody
	public String delQuestion(String question_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(id, null, question_id);
		System.out.println(relation);
		
		questionService.delQuestion(relation);		
		return "success";
	}
	
	@RequestMapping(value="/by_course", method=RequestMethod.POST)
	@ResponseBody
	public List<Question> byCourse(String course_id, HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		Relation relation = new Relation(id, course_id);
		System.out.println(relation);
		
		return questionService.byCourse(relation);
	}
	
	@RequestMapping(value="/query", method=RequestMethod.POST)
	@ResponseBody
	public Question queryQuestion(String question_id, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(question_id);
		
		Question question = questionService.queryQuestion(question_id);
		System.out.println(question);
		return question;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	@ResponseBody
	public String modifyQuestion(@RequestBody Question question, HttpServletRequest request, HttpServletResponse response) {
		System.err.println(question);
		
		questionService.modifyQuestion(question);
		return "success";
	}
}
