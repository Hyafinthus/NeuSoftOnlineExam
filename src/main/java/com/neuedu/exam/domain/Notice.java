package com.neuedu.exam.domain;

public class Notice {

	private String notice_id; 
	private String user_id;
	private String user_name;
	
	private String course_id;
	private String course_name;
	
	// teacher student all
	private String notice_type;
	private String notice_body;
	
	private String notice_time;
	
	public Notice(String user_id, String course_id, String notice_type, String notice_body, String notice_time) {
		super();
		this.user_id = user_id;
		this.course_id = course_id;
		this.notice_type = notice_type;
		this.notice_body = notice_body;
		this.notice_time = notice_time;
	}

	public Notice() {
		super();
	}

	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public String getNotice_type() {
		return notice_type;
	}

	public void setNotice_type(String notice_type) {
		this.notice_type = notice_type;
	}

	public String getNotice_body() {
		return notice_body;
	}

	public void setNotice_body(String notice_body) {
		this.notice_body = notice_body;
	}

	public String getNotice_time() {
		return notice_time;
	}

	public void setNotice_time(String notice_time) {
		this.notice_time = notice_time;
	}

	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", user_id=" + user_id + ", user_name=" + user_name + ", course_id="
				+ course_id + ", course_name=" + course_name + ", notice_type=" + notice_type + ", notice_body="
				+ notice_body + ", notice_time=" + notice_time + "]";
	}
	
}
