package com.neuedu.exam.domain;

public class TeacherCourse {

	private String teacher_id;
	private String course_id;
	
	public TeacherCourse(String teacher_id, String course_id) {
		super();
		this.teacher_id = teacher_id;
		this.course_id = course_id;
	}
	
	public TeacherCourse() {
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
	
	@Override
	public String toString() {
		return "TeacherCourse [course_id=" + course_id + ", teacher_id=" + teacher_id + "]";
	}

}
