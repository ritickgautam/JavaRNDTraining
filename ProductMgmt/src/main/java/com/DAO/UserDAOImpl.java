package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Model.user;
import com.Utility.DBUtility;


public class UserDAOImpl implements UserDAO {

	DBUtility db = new DBUtility();
	PreparedStatement pst;
	ResultSet rs;
	
	@Override
	public int reguser(user u) throws SQLException {
		String sql ="insert into user(name,contact, email, username, password) values(?,?,?,?,?)";
		pst = db.createPST(sql);
		pst.setString(1, u.getName());
		pst.setLong(2, u.getContact());
		pst.setString(3, u.getEmail());
		pst.setString(4, u.getUsername());
		pst.setString(5, u.getPassword());
		return db.execute(pst);
	}

	@Override
	public user authenticate(String username, String password) throws SQLException {
		String sql = "Select * from user where username =? AND password =?";
		pst = db.createPST(sql);
		pst.setString(1, username);
		pst.setString(2, password);
		rs = db.query(pst);
		if(rs.next())
		{
			user u = new user();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("Name"));
			u.setEmail(rs.getString("Email"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setContact(rs.getLong("contact"));
			return u;
		}
		else
		return null;
	}

}
