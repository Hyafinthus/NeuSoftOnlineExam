package com.neuedu.exam.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.exam.domain.Cache;
import com.neuedu.exam.domain.Answer;
import com.neuedu.exam.domain.Exam;
import com.neuedu.exam.domain.ExamPaper;
import com.neuedu.exam.domain.Question;
import com.neuedu.exam.service.ExamService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	DateTimeFormatter addFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
	DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private ExamService examService;
	
	// 老师发布考试
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String addExam(@RequestBody Exam exam, HttpServletRequest request, HttpServletResponse response) {
		// addId
		LocalDateTime today = LocalDateTime.now();
		String exam_id = addFmt.format(today) + "-" + exam.getCourse_id();
		exam.setExam_id(exam_id);;
		
		// addTeacher
		String teacher_id = (String) request.getSession().getAttribute("id");
		exam.setTeacher_id(teacher_id);
		
		System.out.println("老师发布考试: " + exam);
		
		examService.addExam(exam);
		examService.addQuestion(exam);
		return "success";
	}
	
	// 学生开始考试
	@RequestMapping(value="/start", method=RequestMethod.POST)
	@ResponseBody
	public String startExam(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		String student_id = (String) request.getSession().getAttribute("id");
		LocalDateTime today = LocalDateTime.now();
		
		Exam exam = examService.startTime(new Exam(exam_id));
		ExamPaper examPaper = examService.ifStartExam(new ExamPaper(exam_id, student_id));
		
		// 未开始过
		if(examPaper == null) {
			LocalDateTime exam_time_start = LocalDateTime.parse(exam.getExam_time_start(), timeFmt);
			LocalDateTime exam_time_end = LocalDateTime.parse(exam.getExam_time_end(), timeFmt);
			
			// 未到时间
			if(today.isBefore(exam_time_start)) {
				return "fail";
			}
			// 可以开始
			else {
				LocalDateTime end_time = today.plusMinutes(exam.getExam_length());
				// 开始晚了会超时
				if(exam_time_end.isBefore(end_time)) {
					end_time = exam_time_end;
				}

				ExamPaper startExam = new ExamPaper(exam_id, student_id, today.format(timeFmt), end_time.format(timeFmt));
				System.out.println("学生开始考试: " + startExam);
				
				examService.startExam(startExam);
			}
		}
		return "success";
	}
	
	// 学生考试获取结束时间
	@RequestMapping(value="/end", method=RequestMethod.POST)
	@ResponseBody
	public String getEndTime(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		String student_id = (String) request.getSession().getAttribute("id");	
		ExamPaper examPaper = examService.ifStartExam(new ExamPaper(exam_id, student_id));
		System.out.println("学生考试获取结束时间: " + examPaper);
		
		return examPaper.getEnd_time();
	}
	
	// 学生考试加载考试题目
	@RequestMapping(value="/question", method=RequestMethod.POST)
	@ResponseBody
	public List<Question> getExamQuestion(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		// 选择题正确答案
		Map<Integer, Question> multAnswers = new HashMap<>();
		// 主观题总分
		Map<Integer, Integer> subjScores = new HashMap<>();
		
		// 分离选择与主观
		List<Question> mult = new ArrayList<>();
		List<Question> subj = new ArrayList<>();
		
		List<Question> list = examService.getExamQuestion(exam_id);
		for(Question question : list) {
			if(question.getQuestion_type().equals("subj")) {
				// 存储总分
				subjScores.put(question.getQuestion_id(), question.getQuestion_mark());
				
				subj.add(question);
			} else {
				// 存储正确答案
				multAnswers.put(question.getQuestion_id(), new Question(question));
				
				question.setQuestion_type("mult");
				mult.add(question);
			}
		}
		
		// 存入试卷答案
		if(!Cache.getCache().examMultAnswers.containsKey(exam_id)) {
			Cache.getCache().examMultAnswers.put(exam_id, multAnswers);
		}
		if(!Cache.getCache().examSubjScores.containsKey(exam_id)) {
			Cache.getCache().examSubjScores.put(exam_id, subjScores);
		}

		// 先选择后主观
		list.clear();
		list.addAll(mult);
		list.addAll(subj);
		System.out.println("学生考试加载考试题目: " + list);
		
		return list;
	}
	
	// 学生提交试卷
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	@ResponseBody
	public String submitAnswer(@RequestBody List<JSONObject> list, HttpServletRequest request, HttpServletResponse response) {
		String exam_id = (String) list.get(0).get("student_answer");
		String student_id = (String) request.getSession().getAttribute("id");
		
		// 分离选择与主观
		List<Answer> multAnswers = new ArrayList<>();
		List<Answer> subjAnswers = new ArrayList<>();
		
		for(int i = 1; i < list.size(); i++) {
			Answer answer = new Answer();
			answer.setQuestion_id((Integer) list.get(i).get("question_id"));
			answer.setQuestion_type((String) list.get(i).get("question_type"));
			answer.setStudent_answer((String) list.get(i).get("student_answer"));
			
			if(answer.getQuestion_type().equals("mult")) {
				multAnswers.add(answer);
			} else {
				subjAnswers.add(answer);
			}
		}
		
		String multAnswerJson = JSONArray.fromObject(multAnswers).toString();
		String subjAnswerJson = JSONArray.fromObject(subjAnswers).toString();
		
		// 选择题自动阅卷
		List<Answer> multResult = this.multScore(exam_id, multAnswers);
		int multScore = 0;
		for(Answer answer : multResult) {
			multScore += answer.getStudent_mark();
		}
		
		String multResultJson = JSONArray.fromObject(multResult).toString();
		
		// 写入数据库 ExamPaper
		ExamPaper examPaper = new ExamPaper(exam_id, student_id, multAnswerJson, subjAnswerJson, multResultJson, multScore);
		System.out.println("学生提交试卷: " + examPaper);
		examService.storeHistory(examPaper);
		
		return "success";
	}
	
	// 选择题自动阅卷
	private List<Answer> multScore(String exam_id, List<Answer> multAnswers) {
		// 获取本考试答案
		Map<Integer, Question> correctAnswers = Cache.getCache().examMultAnswers.get(exam_id);
		
		// 分数列表
		List<Answer> multResult = new ArrayList<>();
		
		for(Answer answer : multAnswers) {
			int question_id = answer.getQuestion_id();
			Question question = correctAnswers.get(question_id);
			
			// 判分
			if(answer.getStudent_answer().equals(question.getQuestion_type())) {
				multResult.add(new Answer(question_id, question.getQuestion_mark()));
			} else {
				multResult.add(new Answer(question_id, 0));
			}
		}
		
		return multResult;
	}
	
	// 老师获取学生答题
	@RequestMapping(value="/review", method=RequestMethod.POST)
	@ResponseBody
	public List<ExamPaper> getExamPaper(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		List<ExamPaper> list = examService.getExamPaper(exam_id);
		System.out.println("老师获取学生答题: " + list);
		
		return list;
	}
	
	// 老师提交批改结果
	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	@ResponseBody
	public String confirmReview(@RequestBody List<JSONObject> list, HttpServletRequest request, HttpServletResponse response) {
		// exam_id & student_id
		String exam_id = (String) list.get(0).get("question_type");
		String student_id = (String) list.get(0).get("student_answer");
		
		// 前端传回的每题打分的json 转为list
		List<Answer> subjScores = new ArrayList<>();
		for(int i = 1; i < list.size(); i++) {
			Answer answer = new Answer();
			answer.setQuestion_id((Integer) list.get(i).get("question_id"));
			answer.setStudent_mark((Integer) list.get(i).get("student_mark"));
			subjScores.add(answer);
		}
		
		// 从所有考试主观题总分中取出本场考试
		Map<Integer, Integer> correctScores = Cache.getCache().examSubjScores.get(exam_id);
		
		// list中取出转为map
		List<Answer> subjResult = new ArrayList<>();
		for(Answer answer : subjScores) {
			int question_id = answer.getQuestion_id();
			int student_mark_rate = answer.getStudent_mark();
			
			// 从主观题总分中获取改题总分
			int student_mark = (int) ((double) correctScores.get(question_id) * (double) student_mark_rate / (double) 10);
			subjResult.add(new Answer(question_id, student_mark));
		}
		
		String subjResultJson = JSONArray.fromObject(subjResult).toString();
		
		int subjScore = 0;
		for(Answer answer : subjResult) {
			subjScore += answer.getStudent_mark();
		}
		
		// 写入数据库 ExamPaper
		ExamPaper examPaper = new ExamPaper(exam_id, student_id, subjResultJson, subjScore);
		System.out.println("老师提交批改结果: " + examPaper);
		examService.confirmHistory(examPaper);
		
		return "success";
	}
	
	// 学生查看历史试卷
	@RequestMapping(value="/detail", method=RequestMethod.POST)
	@ResponseBody
	public ExamPaper getDetail(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		String student_id = (String) request.getSession().getAttribute("id");
		
		List<Question> correct = examService.getCorrect(exam_id);
		List<Question> multCorrect = new ArrayList<>();
		List<Question> subjCorrect = new ArrayList<>();
		
		for(Question question : correct) {
			if(question.getQuestion_type().equals("subj")) {
				subjCorrect.add(question);
			} else {
				multCorrect.add(question);
			}
		}
		
		String multAnswerJson = JSONArray.fromObject(multCorrect).toString();
		String subjAnswerJson = JSONArray.fromObject(subjCorrect).toString();
		
		ExamPaper examPaper = examService.getDetail(new ExamPaper(exam_id, student_id));
		examPaper.setMult_correct(multAnswerJson);
		examPaper.setSubj_correct(subjAnswerJson);	
		System.out.println("学生查看历史试卷:" + examPaper);
		
		return examPaper;
	}
}
