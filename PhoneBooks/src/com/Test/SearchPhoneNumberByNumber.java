package com.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.DAO.phoneBookDAO;
import com.DAO.phoneBookDAOImpl;
import com.model.phoneBook;

public class SearchPhoneNumberByNumber {

	static phoneBookDAO pbDAO = new phoneBookDAOImpl();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
			System.out.println("Enter Number you want to search: ");
			Long number= Long.parseLong(sc.nextLine());
			try {
				List<phoneBook> pbList = new ArrayList<>();
				pbList = pbDAO.seachphonebookbyPhoneNumber(number);
				if(pbList.isEmpty()) {
					System.out.println("PhoneBook does not contain this number");
				}
				else {	
					for (Iterator iterator = pbList.iterator(); iterator.hasNext();) {
					phoneBook phoneBook = (phoneBook) iterator.next();
					System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber());
					
				}
					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
}
