package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.AdminResultMapper;
import com.neuedu.exam.domain.ExamPaper;

@Service
public class AdminResultServiceImpl implements AdminResultService {

	@Autowired
	private AdminResultMapper adminResultMapper;

	@Override
	public List<ExamPaper> queryStudentResultsByStudentId(String studentId) {
		return adminResultMapper.queryStudentResultsByStudentId(studentId);
	}

	@Override
	public List<ExamPaper> queryStudentResultsByCourseId(String courseId) {
		return adminResultMapper.queryStudentResultsByCourseId(courseId);
	}
}
