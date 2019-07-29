package com.neuedu.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.exam.dao.PersonalMapper;
import com.neuedu.exam.domain.User;

@Service
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private PersonalMapper personalMapper;
	
	@Override
	public void modifyPassword(User user) {
		personalMapper.modifyPassword(user);
	}

}
