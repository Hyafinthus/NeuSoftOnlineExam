package com.neuedu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.StudentResult;

@Mapper
public interface AdminResultMapper {

	List<StudentResult> queryStudentResultsByStudentId(String studentId);

	List<StudentResult> queryStudentResultsByCourseId(Integer courseId);

}
