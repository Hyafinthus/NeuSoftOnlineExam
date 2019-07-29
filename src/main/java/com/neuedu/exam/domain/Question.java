package com.neuedu.exam.domain;


public class Question {
	
	private int question_id;
	
	private String course_id;
	private String course_name;
	private String teacher_id;
	private String teacher_name;
	
	private String question_rate;
	private int question_mark;
	private String question_type;
	
	private String question_body;
	private String question_a;
	private String question_b;
	private String question_c;
	private String question_d;
	private String question_answer;
	
	public Question() {
		super();
	}

	public Question(int question_id, String course_id, String course_name, String teacher_id, String teacher_name,
			String question_rate, int question_mark, String question_type, String question_body, String question_a,
			String question_b, String question_c, String question_d, String question_answer) {
		super();
		this.question_id = question_id;
		this.course_id = course_id;
		this.course_name = course_name;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.question_rate = question_rate;
		this.question_mark = question_mark;
		this.question_type = question_type;
		this.question_body = question_body;
		this.question_a = question_a;
		this.question_b = question_b;
		this.question_c = question_c;
		this.question_d = question_d;
		this.question_answer = question_answer;
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
	
	public String getCourse_name() {
		return course_name;
	}
	
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	public String getTeacher_id() {
		return teacher_id;
	}
	
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	public String getTeacher_name() {
		return teacher_name;
	}
	
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
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
	
	public String getQuestion_a() {
		return question_a;
	}
	
	public void setQuestion_a(String question_a) {
		this.question_a = question_a;
	}
	
	public String getQuestion_b() {
		return question_b;
	}
	
	public void setQuestion_b(String question_b) {
		this.question_b = question_b;
	}
	
	public String getQuestion_c() {
		return question_c;
	}
	
	public void setQuestion_c(String question_c) {
		this.question_c = question_c;
	}
	
	public String getQuestion_d() {
		return question_d;
	}
	
	public void setQuestion_d(String question_d) {
		this.question_d = question_d;
	}
	
	public String getQuestion_answer() {
		return question_answer;
	}
	
	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", course_id=" + course_id + ", course_name=" + course_name
				+ ", teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", question_rate=" + question_rate
				+ ", question_mark=" + question_mark + ", question_type=" + question_type + ", question_body="
				+ question_body + ", question_a=" + question_a + ", question_b=" + question_b + ", question_c="
				+ question_c + ", question_d=" + question_d + ", question_answer=" + question_answer + "]";
	}
	
	
}
