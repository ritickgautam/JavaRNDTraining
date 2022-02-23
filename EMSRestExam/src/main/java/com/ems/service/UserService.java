<<<<<<< HEAD
package com.ems.service;

import java.util.List;

import com.ems.model.User;

public interface UserService {
	public void registerUser(User user);

	public User authenticate(String email, String password);

	public void updateUser(int id);

	public void deleteUser(int id);

	public User getUserById(int id);

	public User getUserByName(String name);

	public List<User> getUsers();


}
=======
package com.ems.service;

import java.util.List;

import com.ems.model.User;

public interface UserService {
	public void registerUser(User user);

	public User authenticate(String email, String password);

	public void updateUser(int id);

	public void deleteUser(int id);

	public User getUserById(int id);

	public User getUserByName(String name);

	public List<User> getUsers();


}
>>>>>>> ca98932d9306c6218e14d6b42efd1c68119703d8
