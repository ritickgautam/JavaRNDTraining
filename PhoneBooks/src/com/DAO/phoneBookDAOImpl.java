package com.DAO;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.DuplicateNameException;
import com.Exception.DuplicateNumberException;
import com.Utility.DBUtility;
import com.model.phoneBook;

public class phoneBookDAOImpl implements phoneBookDAO {

	DBUtility db = new DBUtility();
	PreparedStatement pstmt;
	ResultSet rs;
	
	@Override
	public int addphonebook(phoneBook pb) throws SQLException {
		String sql = "Insert into phonebook(Name,Number) Values(?,?)";
		pstmt = db.createPST(sql);
		pstmt.setString(1,pb.getName());
		pstmt.setLong(2, pb.getPhoneNumber());
		
		return db.execute(pstmt);
	}

	@Override
	public phoneBook seachphonebookbyID(int id) throws SQLException {
		String sql = "select * from phonebook where id=?";
		pstmt = db.createPST(sql);
		pstmt.setInt(1, id);
		rs = db.query(pstmt);
		phoneBook pb = new phoneBook();
		if(rs.next()) {
			pb.setName(rs.getString("name"));
			pb.setPhoneNumber(rs.getLong("number"));
			pb.setId(rs.getInt("id"));
			return pb;
			
		}
		else
			return null;
	}

	@Override
	public List<phoneBook> seachphonebookbyName(String name) throws SQLException {
		String sql = "select * from phonebook where name=?";
		pstmt = db.createPST(sql);
		pstmt.setString(1, name);
		rs = db.query(pstmt);
		List<phoneBook> pbList = new ArrayList<>();
		while(rs.next()) {
			phoneBook pb = new phoneBook();
			pb.setName(rs.getString("name"));
			pb.setPhoneNumber(rs.getLong("number"));
			pb.setId(rs.getInt("id"));
			pbList.add(pb);
			
		}
		return pbList;
	}

	@Override
	public List<phoneBook> seachphonebookbyPhoneNumber(long number) throws SQLException {
		String sql = "select * from phonebook where number=?";
		pstmt = db.createPST(sql);
		pstmt.setLong(1, number);
		rs = db.query(pstmt);
		List<phoneBook> pbList = new ArrayList<>();
		while(rs.next()) {
			phoneBook pb = new phoneBook();
			pb.setName(rs.getString("name"));
			pb.setPhoneNumber(rs.getLong("number"));
			pb.setId(rs.getInt("id"));
			pbList.add(pb);
		}
		return pbList;
	}

	@Override
	public int updatephonebook(phoneBook pb) throws SQLException {
		String sql = "update phonebook set name=?,number=? where id=?";
		pstmt = db.createPST(sql);
		pstmt.setString(1, pb.getName());
		pstmt.setLong(2, pb.getPhoneNumber());
		pstmt.setInt(3, pb.getId());
		
		return db.execute(pstmt);
	}

	@Override
	public int deletephonebook(phoneBook pb) throws SQLException {
		String sql = "Delete from phonebook where id=?";
		pstmt = db.createPST(sql);
		pstmt.setInt(1, pb.getId());
		return db.execute(pstmt);
	}

	@Override
	public List<phoneBook> getallphonebook() throws SQLException {
		String sql = "Select * from phonebook";
		pstmt = db.createPST(sql);
		rs = db.query(pstmt);
		List<phoneBook> pbList = new ArrayList<>();
		while(rs.next()) {
			phoneBook pb = new phoneBook();
			pb.setId(rs.getInt("id"));
			pb.setName(rs.getString("name"));
			pb.setPhoneNumber(rs.getLong("number"));
			pbList.add(pb);
		}
		return pbList;
	}

	@Override
	public int ifExistEntry(phoneBook pb) throws SQLException, DuplicateNameException, DuplicateNumberException {
		String sql = "Select name, number from phonebook";
		pstmt=db.createPST(sql);
		rs= db.query(pstmt);
		while(rs.next())
		{
			if(rs.getString("name").equals(pb.getName()))
			{
				throw new DuplicateNameException("Name already exist!");
			}
			else
				if(rs.getLong("number") == pb.getPhoneNumber()) {
					throw new DuplicateNumberException("Number already exist !");
				}
		}
		return 1;
	}
	

}
