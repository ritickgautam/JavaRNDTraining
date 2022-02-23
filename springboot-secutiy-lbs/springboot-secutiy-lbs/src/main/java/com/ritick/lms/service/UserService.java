package com.ritick.lms.service;

import java.util.List;
import java.util.Optional;

import com.ritick.lms.model.User;

public interface UserService {
	public void registerUserDetails(User user);
	public void updateUserDetails(User user);
	public void deleteUserDetails(int userId);
	public List<User> getUserDetails();
	public Optional<User> getUserDetailsById(int userId);

}
