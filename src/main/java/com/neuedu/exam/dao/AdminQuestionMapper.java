package com.neuedu.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Question;

@Mapper
public interface AdminQuestionMapper {
	public int[] queryQuestionIds();

	public String queryCourseIdByQuestionId(String questionId);
	
	public String queryCourseNameByCourseId(String courseId);
	
	public String queryTeacherIdByQuestionId(String questionId);
	
	public String queryTeacherNameByTeacherId(String teacherId);

	public void deleteQuestion(String questionId);

	public Question questionDetails(Integer questionId);
}
