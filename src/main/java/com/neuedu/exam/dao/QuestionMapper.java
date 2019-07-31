package com.neuedu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Question;
import com.neuedu.exam.domain.Relation;

@Mapper
public interface QuestionMapper {

	public void addQuestion(Question question);
	
	public void delQuestion(Relation relation);
	
	public List<Question> byCourse(Relation relation);
	
	public Question queryQuestion(String question_id); 
	
	public void modifyQuestion(Question question);
	
}
