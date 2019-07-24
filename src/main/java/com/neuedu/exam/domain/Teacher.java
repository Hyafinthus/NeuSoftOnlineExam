package com.neuedu.exam.domain;

public class Teacher extends User {

	private String teacher_id;

	public Teacher(String name, String password, String teacher_id) {
		super(name, password);
		this.teacher_id = teacher_id;
	}

	public Teacher() {
		super();
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", name=" + name + ", password=" + password + "]";
	}
	
}
