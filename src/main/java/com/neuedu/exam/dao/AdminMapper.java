package com.neuedu.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.exam.domain.Notice;
import com.neuedu.exam.domain.User;

@Mapper
public interface AdminMapper {
	
	public User adminLogin(User user);
	
	public List<User> queryUsers();
	
	public List<User> queryTeachers();
	
	public List<User> queryStudents();
	
	public void deleteStudent(String userId);
	
	public void updatePassword(String userId);
	
	public void addUser(User user);

	public User queryUserById(String userId);

	public void addMessage(Notice notice);

}
