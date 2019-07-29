package com.neuedu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Question;
import com.neuedu.exam.service.AdminQuestionService;

@Controller
@RequestMapping("/admin/question")
public class AdminQuestionController {
	
	@Autowired
	private AdminQuestionService adminQuestionService;
	
	@RequestMapping(value="/queryQuestionIds", method=RequestMethod.GET)
	@ResponseBody
	public int[] queryQuestionIds(){
		System.out.println("---------------------------------------------------------");
		int[] test = adminQuestionService.queryQuestionIds();
		return test;
	}
	
	@RequestMapping(value="/queryCourseName/{questionid}", method=RequestMethod.GET)
	@ResponseBody
	public String queryCourseNameByQuestionId(@PathVariable String questionid){
		return adminQuestionService.queryCourseNameByQuestionId(questionid);
	}
	
	@RequestMapping(value="/queryTeacherName/{questionid}", method=RequestMethod.GET)
	@ResponseBody
	public String queryTeacherNameByQuestionId(@PathVariable String questionid){
		return adminQuestionService.queryTeacherNameByQuestionId(questionid);
	}
	
	@RequestMapping(value="/delete/{questionid}", method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteQuestion(@PathVariable String questionid){
		adminQuestionService.deleteQuestion(questionid);
		return "success";
	}
	
	@RequestMapping(value="/details/{questionid}", method=RequestMethod.GET)
	@ResponseBody
	public Question questionDetails(@PathVariable String questionid){
		Question question=adminQuestionService.questionDetails(Integer.valueOf(questionid));
		/*question.setQuestion_type("mult");
		question.setQuestion_rate("hard");
		question.setQuestion_mark(5);
		question.setQuestion_body("我醉了，为啥？");
		String[] answers={"你傻","你蠢","你呆","你丑"};
		question.setQuestion_choise(answers);
		String answer="D";
		question.setQuestion_answer(answer);*/
		return question;
	}
}
