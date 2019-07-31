package com.neuedu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Exam;
import com.neuedu.exam.domain.Question;

@Mapper
public interface ExamMapper {

	public void addExam(Exam exam);
	
	public Integer countStudent(String course_id);
	
	public String chooseClassroom(Integer count);
	
	public void addQuestion(Exam exam);
	
	public List<Question> getExamQuestion(String exam_id);
	
}
