package com.neuedu.exam.domain;

public class Relation {

	private String teacher_id;
	private String teacher_name;
	
	private String course_id;
	private String course_name;
	private String course_intro;
	
	private String student_id;
	private String student_name;
	
	private String question_id;
	
	// 老师加减课 & 按课程查看题目
	public Relation(String teacher_id, String course_id) {
		super();
		this.teacher_id = teacher_id;
		this.course_id = course_id;
	}
	
	// 老师删除题目
	public Relation(String teacher_id, String course_id, String question_id) {
		super();
		this.teacher_id = teacher_id;
		this.course_id = course_id;
		this.question_id = question_id;
	}
	
	// 学生已未选课
	public Relation(String teacher_id, String teacher_name, String course_id, String course_name, String course_intro) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_intro = course_intro;
	}
	
	// 学生加减课
	public Relation(String teacher_id, String course_id, String student_id, String student_name) {
		super();
		this.teacher_id = teacher_id;
		this.course_id = course_id;
		this.student_id = student_id;
	}

	public Relation() {
		super();
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
	
	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_intro() {
		return course_intro;
	}

	public void setCourse_intro(String course_intro) {
		this.course_intro = course_intro;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	@Override
	public String toString() {
		return "Relation [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", course_id=" + course_id
				+ ", course_name=" + course_name + ", course_intro=" + course_intro + ", student_id=" + student_id
				+ ", student_name=" + student_name + ", question_id=" + question_id + "]";
	}
	
}
