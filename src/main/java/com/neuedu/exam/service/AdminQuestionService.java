package com.neuedu.exam.service;

import com.neuedu.exam.domain.Question;

public interface AdminQuestionService {
	public int[] queryQuestionIds();

	public String queryCourseNameByQuestionId(String questionId);

	public String queryTeacherNameByQuestionId(String questionId);

	public void deleteQuestion(String questionId);

	public Question questionDetails(Integer questionId);
}
