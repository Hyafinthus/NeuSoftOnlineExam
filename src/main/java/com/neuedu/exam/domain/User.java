package com.neuedu.exam.domain;

public class User {
	
	protected String id;
	protected String name;
	protected String password;
	protected String type;
	
	// 查询老师课程
	public User(String id) {
		super();
		this.id = id;
	}

	// 登陆
	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	// 修改密码
	public User(String id, String password, String type) {
		super();
		this.id = id;
		this.password = password;
		this.type = type;
	}

	// 全部
	public User(String id, String name, String password, String type) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public User() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", type=" + type + "]";
	}	
	
}
