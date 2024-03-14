package com.nt.service;

import java.util.List;

import com.nt.bean.User;

public interface IOlxUserService {

	public User registerUser(User user);
	public List<User> getAllUser();
	public User findUserById(Integer id);
	public User findUserByName(String name);
}
