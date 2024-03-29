package com.neuedu.exam.domain;

public class Course {
	
	private String course_id;
	private String course_name;
	private String course_intro;
	
	public Course(String course_id, String course_name, String course_intro) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_intro = course_intro;
	}

	public Course() {
		super();
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

	public String getCourse_intro() {
		return course_intro;
	}

	public void setCourse_intro(String course_intro) {
		this.course_intro = course_intro;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_intro=" + course_intro
				+ "]";
	}
	
}
