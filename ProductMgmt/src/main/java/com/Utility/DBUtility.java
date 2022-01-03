package com.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtility {
	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductMgmt","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PreparedStatement createPST(String sql) throws SQLException{
		return conn.prepareStatement(sql);
	}
	
	public int execute(PreparedStatement pst) throws SQLException{
		return pst.executeUpdate();
	}
	
	public ResultSet query(PreparedStatement pst) throws SQLException
	{
		return pst.executeQuery();
	}
	public boolean testConn() {
		if(conn!=null) {
			return true;
		}
		else
			return false;
	}

}
