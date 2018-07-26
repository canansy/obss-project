package com.springSecurity.services;

import com.springSecurity.bean.User;

public interface UserService {
	public User getUser(int id);
	public void saveUser(User user);
	public User updateUser(int id, User user);
	public void deleteUser(int id);
}
