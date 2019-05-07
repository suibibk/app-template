package com.gdpost.service;

import java.util.List;

import com.gdpost.model.User;

public interface UserService {
	public List<User> findAllUser();
	public void insertUser();
}

