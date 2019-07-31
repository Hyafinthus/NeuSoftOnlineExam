package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.QuestionMapper;
import com.neuedu.exam.domain.Question;
import com.neuedu.exam.domain.Relation;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper questionMapper;
	
	@Override
	public void addQuestion(Question question) {
		questionMapper.addQuestion(question);
	}

	@Override
	public void delQuestion(Relation relation) {
		questionMapper.delQuestion(relation);
	}

	@Override
	public List<Question> byCourse(Relation relation) {
		return questionMapper.byCourse(relation);
	}

	@Override
	public Question queryQuestion(String question_id) {
		return questionMapper.queryQuestion(question_id);
	}

	@Override
	public void modifyQuestion(Question question) {
		questionMapper.modifyQuestion(question);
	}
	
}
