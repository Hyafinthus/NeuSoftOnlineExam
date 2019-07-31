package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.Question;
import com.neuedu.exam.domain.Relation;

public interface QuestionService {

	public void addQuestion(Question question);
	
	public void delQuestion(Relation relation);
	
	public List<Question> byCourse(Relation relation);
	
	public Question queryQuestion(String question_id);
	
	public void modifyQuestion(Question question);
	
}
