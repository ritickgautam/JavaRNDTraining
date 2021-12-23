package com.DAO;

import java.sql.SQLException;
import java.util.List;

import com.Exception.DuplicateNameException;
import com.Exception.DuplicateNumberException;
import com.model.phoneBook;

public interface phoneBookDAO {
	public int addphonebook(phoneBook pb) throws SQLException;
	
	public phoneBook seachphonebookbyID(int id) throws SQLException;
	public List<phoneBook> seachphonebookbyName(String name) throws SQLException;
	public List<phoneBook> seachphonebookbyPhoneNumber(long number) throws SQLException;
	
	public int updatephonebook(phoneBook pb) throws SQLException;
	
	public int deletephonebook(phoneBook pb) throws SQLException;
	
	public List<phoneBook> getallphonebook() throws SQLException;
	
	public int ifExistEntry(phoneBook pb) throws SQLException, DuplicateNameException, DuplicateNumberException;

}
