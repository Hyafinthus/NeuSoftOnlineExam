package com.neuedu.exam.domain;

/**
 * 一张试卷某个学生的所有记录
 * 
 * @author Hyafinthus
 */
public class ExamPaper {

	private String exam_id;
	private String student_id;
	private String student_name;
	private String course_id;
	private String course_name;

	private String start_time;
	private String end_time;

	private String mult_answer;
	private String subj_answer;
	private String mult_result;
	private String subj_result;
	private int mult_score;
	private int subj_score;

	// 自动批改选择
	public ExamPaper(String exam_id, String student_id, String mult_answer, String subj_answer, String mult_result,
			int mult_score) {
		super();
		this.exam_id = exam_id;
		this.student_id = student_id;
		this.mult_answer = mult_answer;
		this.subj_answer = subj_answer;
		this.mult_result = mult_result;
		this.mult_score = mult_score;
	}

	// 是否能开始考试
	public ExamPaper(String exam_id, String student_id) {
		super();
		this.exam_id = exam_id;
		this.student_id = student_id;
	}

	// 进入考试
	// 在时间范围内 & 未开始
	public ExamPaper(String exam_id, String student_id, String start_time, String end_time) {
		super();
		this.exam_id = exam_id;
		this.student_id = student_id;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	// 教师批改主观
	public ExamPaper(String exam_id, String student_id, String subj_result, int subj_score) {
		super();
		this.exam_id = exam_id;
		this.student_id = student_id;
		this.subj_result = subj_result;
		this.subj_score = subj_score;
	}

	public ExamPaper() {
		super();
	}

	public String getExam_id() {
		return exam_id;
	}

	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getMult_answer() {
		return mult_answer;
	}

	public void setMult_answer(String mult_answer) {
		this.mult_answer = mult_answer;
	}

	public String getSubj_answer() {
		return subj_answer;
	}

	public void setSubj_answer(String subj_answer) {
		this.subj_answer = subj_answer;
	}

	public String getMult_result() {
		return mult_result;
	}

	public void setMult_result(String mult_result) {
		this.mult_result = mult_result;
	}

	public String getSubj_result() {
		return subj_result;
	}

	public void setSubj_result(String subj_result) {
		this.subj_result = subj_result;
	}

	public int getMult_score() {
		return mult_score;
	}

	public void setMult_score(int mult_score) {
		this.mult_score = mult_score;
	}

	public int getSubj_score() {
		return subj_score;
	}

	public void setSubj_score(int subj_score) {
		this.subj_score = subj_score;
	}

	@Override
	public String toString() {
		return "ExamPaper [exam_id=" + exam_id + ", student_id=" + student_id + ", student_name=" + student_name
				+ ", course_id=" + course_id + ", course_name=" + course_name + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", mult_answer=" + mult_answer + ", subj_answer=" + subj_answer
				+ ", mult_result=" + mult_result + ", subj_result=" + subj_result + ", mult_score=" + mult_score
				+ ", subj_score=" + subj_score + "]";
	}

}
