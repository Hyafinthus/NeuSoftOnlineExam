package com.neuedu.exam.domain;

import java.util.Arrays;

public class Question {
	
	private int question_id;
	
	private String course_id;
	private String teacher_id;
	
	private String question_rate;
	private int question_mark;
	private String question_type;
	
	private String question_body;
	private String[] question_choise; 
	private String question_answer;
	
	public Question(int question_id, String course_id, String teacher_id, String question_rate, int question_mark,
			String question_type, String question_body, String[] question_choise, String question_answer) {
		super();
		this.question_id = question_id;
		this.course_id = course_id;
		this.teacher_id = teacher_id;
		this.question_rate = question_rate;
		this.question_mark = question_mark;
		this.question_type = question_type;
		this.question_body = question_body;
		this.question_choise = question_choise;
		this.question_answer = question_answer;
	}

	public Question() {
		super();
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getQuestion_rate() {
		return question_rate;
	}

	public void setQuestion_rate(String question_rate) {
		this.question_rate = question_rate;
	}

	public int getQuestion_mark() {
		return question_mark;
	}

	public void setQuestion_mark(int question_mark) {
		this.question_mark = question_mark;
	}

	public String getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}

	public String getQuestion_body() {
		return question_body;
	}

	public void setQuestion_body(String question_body) {
		this.question_body = question_body;
	}

	public String[] getQuestion_choise() {
		return question_choise;
	}

	public void setQuestion_choise(String[] question_choise) {
		this.question_choise = question_choise;
	}

	public String getQuestion_answer() {
		return question_answer;
	}

	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", course_id=" + course_id + ", teacher_id=" + teacher_id
				+ ", question_rate=" + question_rate + ", question_mark=" + question_mark + ", question_type="
				+ question_type + ", question_body=" + question_body + ", question_choise="
				+ Arrays.toString(question_choise) + ", question_answer=" + question_answer + "]";
	}
	
}
