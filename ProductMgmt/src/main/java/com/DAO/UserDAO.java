package com.DAO;

import java.sql.SQLException;

import com.Model.user;


public interface UserDAO {
	public int reguser(user u) throws SQLException;
	public user authenticate(String username, String password) throws SQLException;

}
