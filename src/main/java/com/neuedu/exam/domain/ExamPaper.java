package com.neuedu.exam.domain;

import java.util.List;

public class ExamPaper {

	private String exam_id;
	private String student_id;
	private List<Answer> student_paper;
	
	public ExamPaper(String exam_id, String student_id, List<Answer> student_paper) {
		super();
		this.exam_id = exam_id;
		this.student_id = student_id;
		this.student_paper = student_paper;
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
	
	public List<Answer> getStudent_paper() {
		return student_paper;
	}

	public void setStudent_paper(List<Answer> student_paper) {
		this.student_paper = student_paper;
	}

	@Override
	public String toString() {
		return "ExamPaper [exam_id=" + exam_id + ", student_id=" + student_id + ", student_paper=" + student_paper
				+ "]";
	}
	
}
