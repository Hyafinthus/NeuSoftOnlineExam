package com.neuedu.exam.domain;

public class Student extends User {

	private String student_id;
	
	public Student(String name, String password, String student_id) {
		super(name, password);
		this.student_id = student_id;
	}

	public Student() {
		super();
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", password=" + password + "]";
	}

}
