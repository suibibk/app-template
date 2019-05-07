package com.gdpost;

import java.util.List;

import org.apache.log4j.Logger;

import com.gdpost.model.User;
import com.gdpost.service.UserService;
import com.gdpost.utils.SpringUtil;

public class App {
	private static final Logger log = Logger.getLogger(App.class);
	public static void main(String[] args) {
		UserService userService =(UserService) SpringUtil.getBean("userService");
		List<User> users = userService.findAllUser();
		log.info("user:"+users);
		userService.insertUser();
	}
}
