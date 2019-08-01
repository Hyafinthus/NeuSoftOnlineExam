package com.neuedu.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.ExamPaper;
import com.neuedu.exam.service.AdminResultService;

@Controller
@RequestMapping("/admin/result")
public class AdminResultController {

	@Autowired
	private AdminResultService adminResultService;
	
	@RequestMapping(value="/student/{studentid}", method=RequestMethod.GET)
	@ResponseBody
	public List<ExamPaper> showStudentResults(@PathVariable String studentid){
		 List<ExamPaper> temp= adminResultService.queryStudentResultsByStudentId(studentid);
		 for(ExamPaper s:temp)
			 System.out.println(s);
		 return temp;
	}
	
	@RequestMapping(value="/course/{courseid}", method=RequestMethod.GET)
	@ResponseBody
	public List<ExamPaper> showSubjectResults(@PathVariable String courseid){
		return adminResultService.queryStudentResultsByCourseId(courseid);
	}
}
