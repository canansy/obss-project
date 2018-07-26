package com.springSecurity.dao;

import com.springSecurity.bean.User;

public interface UserDao {
	public User getUser(int id);
	public void saveUser(User user);
	public User updateUser(int id, User user);
	public void deleteUser(int id);
}
