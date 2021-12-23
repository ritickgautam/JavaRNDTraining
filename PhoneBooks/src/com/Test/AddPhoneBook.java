package com.Test;

import java.sql.SQLException;
import java.util.Scanner;

import com.DAO.phoneBookDAO;
import com.DAO.phoneBookDAOImpl;
import com.Exception.DuplicateNameException;
import com.Exception.DuplicateNumberException;
import com.model.phoneBook;

public class AddPhoneBook {
	static phoneBookDAO pbDAO = new phoneBookDAOImpl();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter phone number: ");
		long number = Long.parseLong(sc.nextLine());
		
		phoneBook pb = new phoneBook();
		pb.setName(name);
		pb.setPhoneNumber(number);
		int check=0;
		try {
			check = pbDAO.ifExistEntry(pb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateNameException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (DuplicateNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check==1) {

			int flag = 0;
			try {
				flag= pbDAO.addphonebook(pb);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag>0) {
				System.out.println("Successfully Stored: ");
			}
			else
				if(flag==0) {
						System.out.println("Error in new phone Book Entry ");
					}
		}
		
		
	}

}
