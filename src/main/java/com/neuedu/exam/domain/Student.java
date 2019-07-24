package com.neuedu.exam.domain;

public class Student extends User{
	private String name;

	public Student(String id, String password, String name) {
		super(id, password);
		this.name = name;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", password=" + password + "]";
	}

	
	
	
}
