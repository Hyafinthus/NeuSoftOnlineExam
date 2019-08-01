package com.neuedu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.ExamPaper;

@Mapper
public interface AdminResultMapper {

	List<ExamPaper> queryStudentResultsByStudentId(String studentId);

	List<ExamPaper> queryStudentResultsByCourseId(String courseId);

}
