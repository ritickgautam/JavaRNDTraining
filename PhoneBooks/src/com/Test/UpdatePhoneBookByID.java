package com.Test;

import java.sql.SQLException;
import java.util.Scanner;

import com.DAO.phoneBookDAO;
import com.DAO.phoneBookDAOImpl;
import com.model.phoneBook;

public class UpdatePhoneBookByID {
	static phoneBookDAO pbDAO = new phoneBookDAOImpl();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the phoneBook id you want to update: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Updated Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Updated Number: ");
		Long num = Long.parseLong(sc.nextLine());
		
		phoneBook pb = new phoneBook();
		pb.setId(id);
		pb.setName(name);
		pb.setPhoneNumber(num);
		
		int flag = 0;
		try {
			flag=pbDAO.updatephonebook(pb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag>0) {
			System.out.println("Updated successfully");
		}
		else
			System.out.println("Entered wrong id");
	}

}
