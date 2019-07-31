package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.ExamMapper;
import com.neuedu.exam.domain.Exam;
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
	public String chooseClassroom(Integer count) {
		return examMapper.chooseClassroom(count);
	}

	@Override
	public void addQuestion(Exam exam) {
		examMapper.addQuestion(exam.setRate("easy").setNum(exam.getEasy()));
		examMapper.addQuestion(exam.setRate("midd").setNum(exam.getMidd()));
		examMapper.addQuestion(exam.setRate("hard").setNum(exam.getHard()));
	}
	
	@Override
	public List<Question> getExamQuestion(String exam_id) {
		return examMapper.getExamQuestion(exam_id);
	}
	
}
