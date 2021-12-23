package com.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.DAO.phoneBookDAO;
import com.DAO.phoneBookDAOImpl;
import com.model.phoneBook;

public class GetAllPhonebookRecords {

	static phoneBookDAO pbDAO = new phoneBookDAOImpl();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		List<phoneBook> pblist= new ArrayList<>();
		try {
			pblist = pbDAO.getallphonebook();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pblist.isEmpty()) {
			System.out.println("PhoneBook does not contain any records ");
		}
		else
			for (Iterator iterator = pblist.iterator(); iterator.hasNext();) {
				phoneBook phoneBook = (phoneBook) iterator.next();
				System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber());
				
				
			}
		
			
	}
}
