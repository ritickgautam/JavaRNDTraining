package com.Service;

import java.sql.SQLException;

import com.DAO.UserDAO;
import com.DAO.UserDAOImpl;
import com.Model.user;

public class UserServiceImpl implements UserService{

	UserDAO dao = new UserDAOImpl();
	@Override
	public int reguser(user u) throws SQLException {
		return dao.reguser(u);
		
	}

	@Override
	public user authenticate(String username, String password) throws SQLException {
		user u = dao.authenticate(username, password);
		if(u!=null) {
			return u;
		}
		return null;
	}

}
