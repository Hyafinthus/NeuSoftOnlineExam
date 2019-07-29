package com.neuedu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.User;

@Mapper
public interface AdminMapper {
	public List<User> queryUsers();
	
	public List<User> queryTeachers();
	
	public List<User> queryStudents();
	
	public void deleteStudent(String userId);
	
	public void updatePassword(String userId);
	
	public void addUser(User user);

	public User queryUserById(String userId);

	public int[] queryQuestionIds();

	public String queryCourseIdByQuestionId(String questionId);
	
	public String queryCourseNameByCourseId(String courseId);
	
	public String queryTeacherIdByQuestionId(String questionId);
	
	public String queryTeacherNameByTeacherId(String teacherId);
}
