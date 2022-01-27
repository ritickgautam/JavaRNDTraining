package com.ems.dao;

import java.util.List;

import com.ems.model.User;

public interface UserDAO {
	public void registerUser(User user);

	public User authenticate(String email, String password);

	public void updateUser(int id);

	public void deleteUser(int id);

	public User getUserById(int id);

	public User getUserByName(String name);

	public List<User> getUsers();


}
