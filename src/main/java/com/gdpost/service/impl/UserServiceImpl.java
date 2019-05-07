package com.gdpost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdpost.mapper.UserMapper;
import com.gdpost.model.User;
import com.gdpost.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	public List<User> findAllUser() {
		List<User> users = userMapper.findAllUser();
		return users;
	}
	//事务控制成功
	@Transactional
	public void insertUser() {
		User user1 = new User();
		user1.setId(1l);
		user1.setUsername("1");
		user1.setPassword("1");
		user1.setUserId("1");
		userMapper.insertUser(user1);
		int i=1/0;
		User user2 = new User();
		user2.setId(2l);
		user2.setUsername("2"+i);
		user2.setPassword("2");
		user2.setUserId("2");
		userMapper.insertUser(user2);
		
	}

}
