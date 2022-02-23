package com.ritick.lms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritick.lms.dao.UserDAO;
import com.ritick.lms.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;

	@Override
	@Transactional
	public void registerUserDetails(User user) {
		dao.save(user);

	}

	@Override
	@Transactional
	public void updateUserDetails(User user) {
		dao.save(user);
	}

	@Override
	public void deleteUserDetails(int userId) {
		dao.deleteById(userId);
	}

	@Override
	public List<User> getUserDetails() {
		return (List<User>) dao.findAll();
	}

	@Override
	public Optional<User> getUserDetailsById(int userId) {
		// TODO Auto-generated method stub
		return dao.findById(userId);
	}

}
