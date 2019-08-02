package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.ExamMapper;
import com.neuedu.exam.domain.Exam;
import com.neuedu.exam.domain.ExamPaper;
import com.neuedu.exam.domain.Question;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamMapper examMapper;
	
	@Override
	public void addExam(Exam exam) {
		examMapper.addExam(exam);
	}

	@Override
	public Integer countStudent(String course_id) {
		return examMapper.countStudent(course_id);
	}

	@Override
	public void addQuestion(Exam exam) {
		examMapper.addQuestion(exam.setRate("easy").setNum(exam.getEasy()));
		examMapper.addQuestion(exam.setRate("midd").setNum(exam.getMidd()));
		examMapper.addQuestion(exam.setRate("hard").setNum(exam.getHard()));
	}

	
	
	@Override
	public Exam startTime(Exam exam) {
		return examMapper.startTime(exam);
	}
	
	@Override
	public ExamPaper ifStartExam(ExamPaper examPaper) {
		return examMapper.ifStartExam(examPaper);
	}
	
	@Override
	public void startExam(ExamPaper examPaper) {
		examMapper.startExam(examPaper);
	}
	
	@Override
	public List<Question> getExamQuestion(String exam_id) {
		return examMapper.getExamQuestion(exam_id);
	}

	@Override
	public void storeHistory(ExamPaper examPaper) {
		examMapper.storeHistory(examPaper);
	}

	
	
	@Override
	public List<ExamPaper> getExamPaper(String exam_id) {
		return examMapper.getExamPaper(exam_id);
	}

	@Override
	public void confirmHistory(ExamPaper examPaper) {
		examMapper.confirmHistory(examPaper);
	}

	@Override
	public List<Question> getCorrect(String exam_id) {
		return examMapper.getCorrect(exam_id);
	}
	
	@Override
	public ExamPaper getDetail(ExamPaper examPaper) {
		return examMapper.getDetail(examPaper);
	}
	
}
