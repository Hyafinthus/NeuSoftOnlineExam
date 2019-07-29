package com.neuedu.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.AdminQuestionMapper;
import com.neuedu.exam.domain.Question;

@Service
public class AdminQuestionServiceImpl implements AdminQuestionService {
	
	@Autowired
	private AdminQuestionMapper adminQuestionMapper;
	
	@Override
	public int[] queryQuestionIds() {
		return adminQuestionMapper.queryQuestionIds();
	}

	@Override
	public String queryCourseNameByQuestionId(String questionId) {
		String courseId=adminQuestionMapper.queryCourseIdByQuestionId(questionId);
		return adminQuestionMapper.queryCourseNameByCourseId(courseId);
	}

	@Override
	public String queryTeacherNameByQuestionId(String questionId) {
		String teacherId=adminQuestionMapper.queryTeacherIdByQuestionId(questionId);
		return adminQuestionMapper.queryTeacherNameByTeacherId(teacherId);
	}

	@Override
	public void deleteQuestion(String questionId) {
		adminQuestionMapper.deleteQuestion(questionId);
	}

	@Override
	public Question questionDetails(Integer questionId) {
		return adminQuestionMapper.questionDetails(questionId);
	}
}
