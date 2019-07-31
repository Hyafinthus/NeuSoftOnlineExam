package com.neuedu.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.StudentResult;
import com.neuedu.exam.service.AdminResultService;

@Controller
@RequestMapping("/admin/result")
public class AdminResultController {

	@Autowired
	private AdminResultService adminResultService;
	
	@RequestMapping(value="/student/{studentid}", method=RequestMethod.GET)
	@ResponseBody
	public List<StudentResult> showStudentResults(@PathVariable String studentid){
		return adminResultService.queryStudentResultsByStudentId(studentid);
	}
	
	@RequestMapping(value="/course/{courseid}", method=RequestMethod.GET)
	@ResponseBody
	public List<StudentResult> showSubjectResults(@PathVariable String courseid){
		return adminResultService.queryStudentResultsByCourseId(Integer.parseInt(courseid));
	}
}
