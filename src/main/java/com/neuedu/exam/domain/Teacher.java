package com.neuedu.exam.domain;

public class Teacher extends User {

	private String name;

	public Teacher(String id, String password, String name) {
		super(id, password);
		this.name = name;
	}

	public Teacher() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", id=" + id + ", password=" + password + "]";
	}

}
