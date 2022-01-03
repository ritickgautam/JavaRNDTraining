package com.test;

import java.util.Scanner;

import com.DAO.UserDAO;
import com.DAO.UserDAOImpl;

public class testAuthenticate {
	public static void main(String[] args) {
		UserDAO dao = new UserDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String loginName = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
	}

}
