package com.neuedu.exam.domain;

import java.util.List;

public class Exam {
	
	private String exam_id;
	private String course_id;
	
	private List<String> classroom_id;
	private List<String> teacher_id;
	private List<List<String>> students;
	
	private List<List<String>> answers;
	private List<List<Integer>> scores;
	
	public Exam(String exam_id, String course_id, List<String> classroom_id, List<String> teacher_id,
			List<List<String>> students, List<List<String>> answers, List<List<Integer>> scores) {
		super();
		this.exam_id = exam_id;
		this.course_id = course_id;
		this.classroom_id = classroom_id;
		this.teacher_id = teacher_id;
		this.students = students;
		this.answers = answers;
		this.scores = scores;
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
	
	public List<String> getClassroom_id() {
		return classroom_id;
	}
	
	public void setClassroom_id(List<String> classroom_id) {
		this.classroom_id = classroom_id;
	}
	
	public List<String> getTeacher_id() {
		return teacher_id;
	}
	
	public void setTeacher_id(List<String> teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	public List<List<String>> getStudents() {
		return students;
	}
	
	public void setStudents(List<List<String>> students) {
		this.students = students;
	}
	
	public List<List<String>> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<List<String>> answers) {
		this.answers = answers;
	}
	
	public List<List<Integer>> getScores() {
		return scores;
	}
	
	public void setScores(List<List<Integer>> scores) {
		this.scores = scores;
	}
	
	@Override
	public String toString() {
		return "Exam [exam_id=" + exam_id + ", course_id=" + course_id + ", classroom_id=" + classroom_id
				+ ", teacher_id=" + teacher_id + ", students=" + students + ", answers=" + answers + ", scores="
				+ scores + "]";
	}

}
