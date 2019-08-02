package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.Notice;
import com.neuedu.exam.domain.Relation;

public interface CourseService {
	
	public void joinCourse(Relation relation);
	
	public void quitCourse(Relation relation);
	
	public void electiveCourse(Relation relation);
	
	public void withdrawCourse(Relation relation);
	
	public List<Relation> byCourse(Relation relation);
	
	public void sendNotice(Notice notice);
	
}
