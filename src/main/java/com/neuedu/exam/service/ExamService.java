package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.Exam;
import com.neuedu.exam.domain.ExamPaper;
import com.neuedu.exam.domain.Question;

public interface ExamService {
	
	public void addExam(Exam exam);
	
	public Integer countStudent(String course_id);
	
	public String chooseClassroom(Integer count);
	
	public void addQuestion(Exam exam);
	
	
	
	public Exam startTime(Exam exam);
	
	public ExamPaper ifStartExam(ExamPaper examPaper);
	
	public void startExam(ExamPaper examPaper);
	
	public List<Question> getExamQuestion(String exam_id);
	
	public void storeHistory(ExamPaper examPaper);
	
	
	
	public List<ExamPaper> getExamPaper(String exam_id);
	
	public void confirmHistory(ExamPaper examPaper);
	
}
