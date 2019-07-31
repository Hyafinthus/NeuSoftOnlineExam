package com.neuedu.exam.domain;

public class StudentResult {
	
	private String studentId;
	private String studentName;
	
	private Integer courseId;
	private String courseName;
	
	private String examId;
	private Integer studentScore;
	
	public StudentResult() {
		super();
	}

	public StudentResult(String studentId, String studentName, Integer courseId, String courseName, String examId,
			Integer studentScore) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.examId = examId;
		this.studentScore = studentScore;
	}

	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Integer getCourseId() {
		return courseId;
	}
	
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getExamId() {
		return examId;
	}
	
	public void setExamId(String examId) {
		this.examId = examId;
	}
	
	public Integer getStudentResult() {
		return studentScore;
	}
	
	public void setStudentResult(Integer studentScore) {
		this.studentScore = studentScore;
	}

	@Override
	public String toString() {
		return "StudentResult [studentId=" + studentId + ", studentName=" + studentName + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", examId=" + examId + ", studentScore=" + studentScore + "]";
	}

	
	
}
