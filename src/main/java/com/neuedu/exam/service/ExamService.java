package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.Exam;
import com.neuedu.exam.domain.Question;

public interface ExamService {
	
	public void addExam(Exam exam);
	
	public Integer countStudent(String course_id);
	
	public String chooseClassroom(Integer count);
	
	public void addQuestion(Exam exam);
	
	public List<Question> getExamQuestion(String exam_id);
	
}
