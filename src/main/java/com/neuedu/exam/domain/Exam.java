package com.neuedu.exam.domain;

public class Exam {
	
	private String exam_id;
	private String course_id;
	private String course_name;
	private String teacher_id;
	private String teacher_name;
	
	private String rate;
	private int num;
	
	private int easy;
	private int midd;
	private int hard;
	
	private String exam_classroom;
	private String exam_time_start;
	private String exam_time_end;
	private int exam_length;

	public Exam(String exam_id, String course_id, String course_name, String teacher_id, String teacher_name, int easy,
			int midd, int hard, String exam_classroom, String exam_time_start, String exam_time_end,
			int exam_length) {
		super();
		this.exam_id = exam_id;
		this.course_id = course_id;
		this.course_name = course_name;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.easy = easy;
		this.midd = midd;
		this.hard = hard;
		this.exam_classroom = exam_classroom;
		this.exam_time_start = exam_time_start;
		this.exam_time_end = exam_time_end;
		this.exam_length = exam_length;
	}

	public Exam(String exam_id) {
		super();
		this.exam_id = exam_id;
	}

	public Exam() {
		super();
	}
	
	public String getExam_id() {
		return exam_id;
	}
	
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	
	public String getCourse_id() {
		return course_id;
	}
	
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	
	public String getExam_classroom() {
		return exam_classroom;
	}
	
	public void setExam_classroom(String exam_classroom) {
		this.exam_classroom = exam_classroom;
	}
	
	public String getTeacher_id() {
		return teacher_id;
	}
	
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	public String getExam_time_start() {
		return exam_time_start;
	}
	
	public void setExam_time_start(String exam_time_start) {
		this.exam_time_start = exam_time_start;
	}
	
	public String getExam_time_end() {
		return exam_time_end;
	}
	
	public void setExam_time_end(String exam_time_end) {
		this.exam_time_end = exam_time_end;
	}
	
	public int getExam_length() {
		return exam_length;
	}
	
	public void setExam_length(int exam_length) {
		this.exam_length = exam_length;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public int getEasy() {
		return easy;
	}

	public void setEasy(int easy) {
		this.easy = easy;
	}

	public int getMidd() {
		return midd;
	}

	public void setMidd(int midd) {
		this.midd = midd;
	}

	public int getHard() {
		return hard;
	}

	public void setHard(int hard) {
		this.hard = hard;
	}

	public String getRate() {
		return rate;
	}

	public Exam setRate(String rate) {
		this.rate = rate;
		return this;
	}

	public int getNum() {
		return num;
	}

	public Exam setNum(int num) {
		this.num = num;
		return this;
	}
	
	@Override
	public String toString() {
		return "Exam [exam_id=" + exam_id + ", course_id=" + course_id + ", course_name=" + course_name
				+ ", teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", easy=" + easy + ", midd=" + midd
				+ ", hard=" + hard + ", exam_classroom=" + exam_classroom + ", exam_time_start=" + exam_time_start
				+ ", exam_time_end=" + exam_time_end + ", exam_length=" + exam_length + "]";
	}
	
}
