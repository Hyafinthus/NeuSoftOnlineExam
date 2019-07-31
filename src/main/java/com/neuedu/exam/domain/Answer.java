package com.neuedu.exam.domain;

public class Answer {
	
	private int question_id; 
	private String question_type;
	private String student_answer;
	
	public Answer(int question_id, String question_type, String student_answer) {
		super();
		this.question_id = question_id;
		this.question_type = question_type;
		this.student_answer = student_answer;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}

	public String getStudent_answer() {
		return student_answer;
	}

	public void setStudent_answer(String student_answer) {
		this.student_answer = student_answer;
	}

	@Override
	public String toString() {
		return "Answer [question_id=" + question_id + ", question_type=" + question_type + ", student_answer="
				+ student_answer + "]";
	}
	
}
