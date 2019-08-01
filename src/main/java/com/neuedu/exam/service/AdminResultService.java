package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.ExamPaper;

public interface AdminResultService {

	List<ExamPaper> queryStudentResultsByStudentId(String studentId);

	List<ExamPaper> queryStudentResultsByCourseId(String courseid);

}
