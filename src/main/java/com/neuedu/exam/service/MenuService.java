package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.Exam;
import com.neuedu.exam.domain.ExamPaper;
import com.neuedu.exam.domain.Question;
import com.neuedu.exam.domain.Relation;
import com.neuedu.exam.domain.User;

public interface MenuService {
	
	public List<Course> getTeacherCourse(User user);
	
	public List<Course> getTeacherCandidate(User user);
	
	public List<Question> getQuestion(User user);
	
	public List<Exam> getExam(User user);
	
	public List<Relation> getStudentCourse(User user);
	
	public List<Relation> getStudentCandidate(User user);
	
	public List<Exam> getStudentExam(User user);
	
	public List<ExamPaper> getStudentScore(User user);
	
}
