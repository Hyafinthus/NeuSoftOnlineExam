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
		
		// addClassroom
		int count = examService.countStudent(exam.getCourse_id());
		String classroom = examService.chooseClassroom(count);
		exam.setExam_classroom(classroom);
		
		System.out.println(exam);
		
		examService.addExam(exam);
		examService.addQuestion(exam);
		return "success";
	}
	
	// 学生开始考试
	@RequestMapping(value="/start", method=RequestMethod.POST)
	@ResponseBody
	public String startExam(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(exam_id);
		
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
				examService.startExam(startExam);
			}
		}
		return "success";
	}
	
	// 获取结束时间
	@RequestMapping(value="/end", method=RequestMethod.POST)
	@ResponseBody
	public String getEndTime(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		String student_id = (String) request.getSession().getAttribute("id");	
		ExamPaper examPaper = examService.ifStartExam(new ExamPaper(exam_id, student_id));
		return examPaper.getEnd_time();
	}
	
	// 加载考试题目
	@RequestMapping(value="/question", method=RequestMethod.POST)
	@ResponseBody
	public List<Question> getExamQuestion(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(exam_id);
		
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
				System.out.println("multAnswers: " + multAnswers);
				
				question.setQuestion_type("mult");
				mult.add(question);
			}
		}
		
		// 存入试卷答案
		if(!Cache.getCache().examMultAnswers.containsKey(exam_id)) {
			Cache.getCache().examMultAnswers.put(exam_id, multAnswers);
		}
		System.out.println("examMultAnswers: " + Cache.getCache().examMultAnswers);
		if(!Cache.getCache().examSubjScores.containsKey(exam_id)) {
			Cache.getCache().examSubjScores.put(exam_id, subjScores);
		}

		// 先选择后主观
		list.clear();
		list.addAll(mult);
		list.addAll(subj);
		System.out.println(list);
		return list;
	}
	
	// 学生提交试卷
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	@ResponseBody
	public String submitAnswer(@RequestBody List<JSONObject> list, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(list);
		
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
		Map<Integer, Integer> multResult = this.multScore(exam_id, multAnswers);
		int multScore = 0;
		for(Integer score : multResult.values()) {
			multScore += score;
		}
		
		String multResultJson = JSONArray.fromObject(multResult).toString();
		System.out.println(multResultJson);
		
		// 写入数据库 ExamPaper
		ExamPaper examPaper = new ExamPaper(exam_id, student_id, multAnswerJson, subjAnswerJson, multResultJson, multScore);
		examService.storeHistory(examPaper);
		System.out.println(examPaper);
		
		return "success";
	}
	
	// 选择题自动阅卷
	private Map<Integer, Integer> multScore(String exam_id, List<Answer> multAnswers) {
		// 获取本考试答案
		Map<Integer, Question> correctAnswers = Cache.getCache().examMultAnswers.get(exam_id);
		
		// 分数列表
		Map<Integer, Integer> multResult = new HashMap<>();
		
		for(Answer answer : multAnswers) {
			int question_id = answer.getQuestion_id();
			Question question = correctAnswers.get(question_id);
			
			// 判分
			if(answer.getStudent_answer().equals(question.getQuestion_type())) {
				multResult.put(question_id, question.getQuestion_mark());
			} else {
				multResult.put(question_id, 0);
			}
		}
		
		return multResult;
	}
	
	// 老师获取学生答题
	@RequestMapping("/review")
	@ResponseBody
	public List<ExamPaper> getExamPaper(String exam_id, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(exam_id);
		
		List<ExamPaper> list = examService.getExamPaper(exam_id);
		System.out.println(list);
		return list;
	}
	
	// 老师提交批改结果
	@RequestMapping("/confirm")
	@ResponseBody
	public String confirmReview(@RequestBody List<JSONObject> list, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(list);
		
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
		System.out.println(correctScores);
		
		// list中取出转为map
		HashMap<Integer, Integer> subjResult = new HashMap<>();
		for(Answer answer : subjScores) {
			int question_id = answer.getQuestion_id();
			int student_mark_rate = answer.getStudent_mark();
			
			// 从主观题总分中获取改题总分
			int student_mark = (int) ((double) correctScores.get(question_id) * (double) student_mark_rate / (double) 10);
			subjResult.put(question_id, student_mark);
		}
		
		String subjResultJson = JSONArray.fromObject(subjResult).toString();
		
		int subjScore = 0;
		for(Integer score : subjResult.values()) {
			subjScore += score;
		}
		
		// 写入数据库 ExamPaper
		ExamPaper examPaper = new ExamPaper(exam_id, student_id, subjResultJson, subjScore);
		examService.confirmHistory(examPaper);
		System.out.println(examPaper);
		
		return "success";
	}
}
