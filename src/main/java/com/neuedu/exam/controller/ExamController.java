package com.neuedu.exam.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Exam;
import com.neuedu.exam.domain.ExamPaper;
import com.neuedu.exam.domain.Question;
import com.neuedu.exam.service.ExamService;

@Controller
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String addExam(@RequestBody Exam exam, HttpServletRequest request, HttpServletResponse response) {
		// addId
		LocalDateTime today = LocalDateTime.now();
		String exam_id = today.toString().split("T")[0] + "-" + exam.getCourse_id();
		exam.setExam_id(exam_id);;
		
		// addTeacher
		String teacher_id = (String) request.getSession().getAttribute("id");
		exam.setTeacher_id(teacher_id);
		
		// addClassroom
		int count = examService.countStudent(exam.getCourse_id());
		String classroom = examService.chooseClassroom(count);
		exam.setExam_classroom(classroom);
		
		System.out.println(exam);
		
		examService.addExam(exam);
		examService.addQuestion(exam);
		return "success";
	}
	
	@RequestMapping(value="/question", method=RequestMethod.POST)
	@ResponseBody
	public List<Question> getExamQuestion(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(exam_id);
		
		List<Question> mult = new ArrayList<>();
		List<Question> subj = new ArrayList<>();
		
		List<Question> list = examService.getExamQuestion(exam_id);
		
		for(Question question : list) {
			if(question.getQuestion_type().equals("subj")) {
				subj.add(question);
			} else {
				question.setQuestion_type("mult");
				mult.add(question);
			}
		}

		list.clear();
		list.addAll(mult);
		list.addAll(subj);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	@ResponseBody
	public String submitAnswer(@RequestBody List<ExamPaper> list, HttpServletRequest request, HttpServletResponse response) {
		
		return "success";
	}
	
}
