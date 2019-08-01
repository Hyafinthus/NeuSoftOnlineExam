package com.neuedu.exam.domain;

/**
 * 每一道题的答案
 * 
 * @author Hyafinthus
 */
public class Answer {
	
	private int question_id;
	private String question_type;
	private String student_answer;
	
	private int student_mark;

	public Answer() {
		super();
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

	public int getStudent_mark() {
		return student_mark;
	}

	public void setStudent_mark(int student_mark) {
		this.student_mark = student_mark;
	}

	@Override
	public String toString() {
		return "Answer [question_id=" + question_id + ", question_type=" + question_type + ", student_answer="
				+ student_answer + ", student_mark=" + student_mark + "]";
	}
	
}
