package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.AdminResultMapper;
import com.neuedu.exam.domain.StudentResult;

@Service
public class AdminResultServiceImpl implements AdminResultService {

	@Autowired
	private AdminResultMapper adminResultMapper;

	@Override
	public List<StudentResult> queryStudentResultsByStudentId(String studentId) {
		List<StudentResult> temp= adminResultMapper.queryStudentResultsByStudentId(studentId);
		System.out.println(temp.get(0));
		return temp;
	}

	@Override
	public List<StudentResult> queryStudentResultsByCourseId(Integer courseId) {
		return adminResultMapper.queryStudentResultsByCourseId(courseId);
	}
}
