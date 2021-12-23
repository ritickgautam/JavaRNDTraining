package com.Test;

import java.sql.SQLException;
import java.util.Scanner;

import com.DAO.phoneBookDAO;
import com.DAO.phoneBookDAOImpl;
import com.model.phoneBook;

public class DeletePhoneBookByID {
	static phoneBookDAO pbDAO = new phoneBookDAOImpl();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the phoneBook id you want to delete: ");
		int id = Integer.parseInt(sc.nextLine());
		
		phoneBook pb = new phoneBook();
		pb.setId(id);
		
		int flag=0;
		try {
			flag = pbDAO.deletephonebook(pb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag>0) {
			System.out.println("Deleted Successfully");
		}
		else
			System.out.println("Invalid PhonebookID");
		
	}

}
