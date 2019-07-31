package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.StudentResult;

public interface AdminResultService {

	List<StudentResult> queryStudentResultsByStudentId(String studentId);

	List<StudentResult> queryStudentResultsByCourseId(Integer courseid);

}
