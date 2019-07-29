package com.neuedu.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.AdminMapper;
import com.neuedu.exam.domain.User;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public User adminLogin(User user) {
		return adminMapper.adminLogin(user);
	}
	
	@Override
	public List<User> queryUsers() {
		return adminMapper.queryUsers();
	}

	@Override
	public List<User> queryTeachers() {
		return adminMapper.queryTeachers();
	}

	@Override
	public List<User> queryStudents() {
		return adminMapper.queryStudents();
	}

	@Override
	public void deleteStudent(String userId) {
		adminMapper.deleteStudent(userId);
	}

	@Override
	public void updatePassword(String userId) {
		adminMapper.updatePassword(userId);
	}

	@Override
	public void addUser(User user) {
		adminMapper.addUser(user);
	}

	@Override
	public User queryUserById(String userId) {
		return adminMapper.queryUserById(userId);
	}

}
