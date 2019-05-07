package com.gdpost.mapper;

import java.util.List;

import com.gdpost.model.User;
public interface UserMapper {
	public List<com.gdpost.model.User> findAllUser();
	public void insertUser(User user);
}
