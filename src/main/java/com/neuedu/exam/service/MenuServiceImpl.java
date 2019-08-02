package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.MenuMapper;
import com.neuedu.exam.domain.Course;
import com.neuedu.exam.domain.Exam;
import com.neuedu.exam.domain.ExamPaper;
import com.neuedu.exam.domain.Notice;
import com.neuedu.exam.domain.Question;
import com.neuedu.exam.domain.Relation;
import com.neuedu.exam.domain.User;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Course> getTeacherCourse(User user) {
		return menuMapper.getTeacherCourse(user);
	}

	@Override
	public List<Course> getTeacherCandidate(User user) {
		return menuMapper.getTeacherCandidate(user);
	}

	@Override
	public List<Question> getQuestion(User user) {
		return menuMapper.getQuestion(user);
	}

	@Override
	public List<Exam> getExam(User user) {
		return menuMapper.getExam(user);
	}

	@Override
	public List<Relation> getStudentCourse(User user) {
		return menuMapper.getStudentCourse(user);
	}

	@Override
	public List<Relation> getStudentCandidate(User user) {
		return menuMapper.getStudentCandidate(user);
	}

	@Override
	public List<Exam> getStudentExam(User user) {
		return menuMapper.getStudentExam(user);
	}

	@Override
	public List<ExamPaper> getStudentScore(User user) {
		return menuMapper.getStudentScore(user);
	}

	@Override
	public List<Relation> getStudent(User user) {
		return menuMapper.getStudent(user);
	}

	@Override
	public List<Notice> getNotice(User user) {
		return menuMapper.getNotice(user);
	}

}
