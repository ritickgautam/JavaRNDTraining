package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.dao.UserDAO;
import com.ems.model.User;

@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;


	@Override
	public List<User> getUsers() {
		return dao.getUsers();

	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return dao.getUserById(id);
	}

	@Override
	public void registerUser(User user) {
		dao.registerUser(user);

	}


	@Override
	public void updateUser(int id) {
		dao.updateUser(id);

	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUser(id);

	}




	@Override
	public User authenticate(String email, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(email, password);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return dao.getUserByName(name);
	}

}
