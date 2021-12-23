package com.Test;

import java.sql.SQLException;

import java.util.Scanner;

import com.DAO.phoneBookDAO;
import com.DAO.phoneBookDAOImpl;
import com.model.phoneBook;

public class SearchPhoneNumberByID {

	static phoneBookDAO pbDAO = new phoneBookDAOImpl();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
			System.out.println("Enter ID you want to search: ");
			int id= Integer.parseInt(sc.nextLine());
			try {
				phoneBook phoneBook = pbDAO.seachphonebookbyID(id);
				if(phoneBook!=null) 
				{
					System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber());
					}
				else 
				{
					System.out.println("PhoneBook does not contain this id");
				}
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
}
