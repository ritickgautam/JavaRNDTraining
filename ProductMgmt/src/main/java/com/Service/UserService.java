package com.Service;

import java.sql.SQLException;

import com.Model.user;

public interface UserService {

	public int reguser(user u) throws SQLException;
	public user authenticate(String username, String password) throws SQLException;


}
