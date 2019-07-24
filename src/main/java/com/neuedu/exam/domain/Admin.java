package com.neuedu.exam.domain;

public class Admin extends User {
	
	private String admin_id;

	public Admin(String name, String password, String admin_id) {
		super(name, password);
		this.admin_id = admin_id;
	}

	public Admin() {
		super();
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", name=" + name + ", password=" + password + "]";
	}

}
