package com.neuedu.exam.service;

import java.util.List;

import com.neuedu.exam.domain.User;

public interface AdminService {
	public List<User> queryUsers();
	
	public List<User> queryTeachers();
	
	public List<User> queryStudents();
	
	public void deleteStudent(String userId);
	
	public void updatePassword(String userId);
	
	public void addUser(User user);

	public User queryUserById(String userId);

	public User adminLogin(User user);

	public List<User> getRecipients(String identity);

	public void addMessage(String addresserName, String addresserId, List<User> recipients, String content,
			String messagedate);
}
